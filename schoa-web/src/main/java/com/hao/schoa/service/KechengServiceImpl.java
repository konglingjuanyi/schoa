package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;

import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.LibrarysPeer;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.po.XueqiPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class KechengServiceImpl {

	public static Map<String, Object> search(int xueqi, int teacherId,
			String name) {
		List<Kecheng> list = getKechengList(xueqi,teacherId,name);
		int size = list==null?0:list.size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, size);
		map.put(Constant.DATA, list);
		return map;
	}
	public static Map<String, Object> searchGrid(int xueqi, int teacherId,
			String name,int start,int limit) {
		
		int size = 0;
		StringBuffer sbr = new StringBuffer();
		StringBuffer searchSql = new StringBuffer();
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		
		searchSql.append(" select ").append(KechengPeer.TABLE_NAME).append(".* ")
		.append(",").append(TeacherPeer.NAME).append(",")
		.append(XueqiPeer.NAME);
		
		
		sbr.append(" from ").append(KechengPeer.TABLE_NAME);
		sbr.append(" left join ").append(TeacherPeer.TABLE_NAME).append(" on ")
		.append(TeacherPeer.ID).append("=")
		.append(KechengPeer.TEACHER_ID);
		sbr.append(" left join ").append(XueqiPeer.TABLE_NAME).append(" on ")
		.append(XueqiPeer.ID).append("=").append(KechengPeer.XUEQI_ID);
		
		sbr.append(" where 1=1 ");
		if (xueqi > 0) {
			sbr.append(" and ").append(KechengPeer.XUEQI_ID).append(" = ")
			.append(xueqi);
		}
		if (teacherId > 0) {
			sbr.append(" and ").append(KechengPeer.TEACHER_ID).append(" = ")
			.append(teacherId);
		}
		if (StringUtils.isNotBlank(name)) {
			sbr.append(" and ").append(KechengPeer.NAME).append(" like '%")
			.append(name).append("%' ");
		}
		
		countSql.append(sbr);
		searchSql.append(sbr);
		
		searchSql.append(" order by ").append(KechengPeer.ID).append(" desc ");
		searchSql.append(" limit ").append(start).append(",").append(limit);
		
		List<Kecheng> list = new ArrayList<Kecheng>();
		try {
			List<Record> countList = LibrarysPeer.executeQuery(countSql.toString());
			List<Record> searchList = KechengPeer.executeQuery(searchSql.toString());
			size = countList.get(0).getValue("count").asInt();
			
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Kecheng obj = KechengPeer.row2Object(row, 1,
						KechengPeer.getOMClass());
				
				Teacher teacher = new Teacher();
				teacher.setId(obj.getTeacherId());
				teacher.setName(row.getValue(TeacherPeer.NAME).asString());
				obj.setTeacher(teacher);
				
				Xueqi xq = new Xueqi();
				xq.setName(row.getValue(XueqiPeer.NAME).asString());
				obj.setXueqi(xq);
				
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, size);
		map.put(Constant.DATA, list);
		return map;
	}

	public static Kecheng retrieveByPK(int id) {
		if (id > 0) {
			try {
				Kecheng kch = KechengPeer.retrieveByPK(id);
				
				if(StringUtils.isNotBlank(kch.getFileUploadFlags())){
					String[] arr = kch.getFileUploadFlags().split(",");
					List<Integer> ls = new ArrayList<Integer>();
					if(arr != null){
						for(int i=0;i<arr.length;i++){
							ls.add(Integer.parseInt(arr[i]));
						}
					}
					kch.setFileFlags(ls);
				}
				return kch;
			} catch (NoRowsException e) {
				e.printStackTrace();
			} catch (TooManyRowsException e) {
				e.printStackTrace();
			} catch (TorqueException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Kecheng getById(int id) {
		if (id > 0) {
			try {
				Kecheng kch = KechengPeer.retrieveByPK(id);
				if (kch != null && kch.getTeacherId() > 0) {
					Teacher teacher = TeacherServiceImpl.getById(kch
							.getTeacherId());
					kch.setTeacher(teacher);
				}

				if (kch != null && kch.getXueqiId() > 0) {
					Xueqi xueqi = XueqiServiceImpl.getById(kch.getXueqiId());
					kch.setXueqi(xueqi);
				}
				
				if(StringUtils.isNotBlank(kch.getFileUploadFlags())){
					String[] arr = kch.getFileUploadFlags().split(",");
					List<Integer> ls = new ArrayList<Integer>();
					if(arr != null){
						for(int i=0;i<arr.length;i++){
							ls.add(Integer.parseInt(arr[i]));
						}
					}
					kch.setFileFlags(ls);
				}
				
				return kch;
			} catch (NoRowsException e) {
				e.printStackTrace();
			} catch (TooManyRowsException e) {
				e.printStackTrace();
			} catch (TorqueException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<Kecheng> getKechengList(int xueqi, int teacherId, String name) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(KechengPeer.TABLE_NAME).append(".* ")
				.append(",").append(TeacherPeer.NAME).append(",")
				.append(XueqiPeer.NAME);

		sbr.append(" from ").append(KechengPeer.TABLE_NAME);
		sbr.append(" left join ").append(TeacherPeer.TABLE_NAME).append(" on ")
				.append(TeacherPeer.ID).append("=")
				.append(KechengPeer.TEACHER_ID);
		sbr.append(" left join ").append(XueqiPeer.TABLE_NAME).append(" on ")
				.append(XueqiPeer.ID).append("=").append(KechengPeer.XUEQI_ID);

		sbr.append(" where 1=1 ");
		if (xueqi > 0) {
			sbr.append(" and ").append(KechengPeer.XUEQI_ID).append(" = ")
					.append(xueqi);
		}
		if (teacherId > 0) {
			sbr.append(" and ").append(KechengPeer.TEACHER_ID).append(" = ")
					.append(teacherId);
		}
		if (StringUtils.isNotBlank(name)) {
			sbr.append(" and ").append(KechengPeer.NAME).append(" like '%")
					.append(name).append("%' ");
		}
		
		sbr.append(" order by ").append(KechengPeer.ID).append(" desc ");

		List<Kecheng> list = new ArrayList<Kecheng>();
		try {
			List<Record> searchList = KechengPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Kecheng obj = KechengPeer.row2Object(row, 1,
						KechengPeer.getOMClass());

				Teacher teacher = new Teacher();
				teacher.setId(obj.getTeacherId());
				teacher.setName(row.getValue(TeacherPeer.NAME).asString());
				obj.setTeacher(teacher);

				Xueqi xq = new Xueqi();
				xq.setName(row.getValue(XueqiPeer.NAME).asString());
				obj.setXueqi(xq);

				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
