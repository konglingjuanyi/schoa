package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.container.JiaoxueFileScore;
import com.hao.schoa.po.JiaoxueFile;
import com.hao.schoa.po.JiaoxueFilePeer;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.po.XueqiPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class JiaoxueFileServiceImpl {
	
	public static Map<String, Object> search(int teacherId, int xueqiId, int kechengId, int start, int limit,Member member) {
		int total = 0;
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		StringBuffer searchSql = new StringBuffer();
		
		searchSql.append(" select ").append(JiaoxueFilePeer.TABLE_NAME).append(".* ");
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(JiaoxueFilePeer.TABLE_NAME);
		
		sbr.append(" where 1=1 ");
		if(xueqiId > 0){
			sbr.append(" and ").append(JiaoxueFilePeer.XUEQI_ID).append(" = ").append(xueqiId);
		}
		if(kechengId > 0){
			sbr.append(" and ").append(JiaoxueFilePeer.KECHENG_ID).append(" = ").append(kechengId);
		}
		if(teacherId != -1){
			sbr.append(" and ").append(JiaoxueFilePeer.TEACHER_ID).append(" = ").append(teacherId);
		}
		
		countSql.append(sbr);
		searchSql.append(sbr)
				.append(" order by ").append(JiaoxueFilePeer.KECHENG_ID).append(" desc ")
				.append(" limit  ").append(start).append(",").append(limit);
		
		List<JiaoxueFile> list = new ArrayList<JiaoxueFile>();
		try {
			List<Record> countList = JiaoxueFilePeer.executeQuery(countSql.toString());
			List<Record> searchList = JiaoxueFilePeer.executeQuery(searchSql.toString());
			total = countList.get(0).getValue("count").asInt();
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				JiaoxueFile obj = JiaoxueFilePeer.row2Object(row, 1, JiaoxueFilePeer.getOMClass());
				
				Kecheng kch = KechengServiceImpl.getById(obj.getKechengId());
				
				obj.setJiaoxueFileScore(Constant.fileFlagMap.get(obj.getFileFlag()));
				
				/////////操作权限判断///////////////////
				boolean quanxian = false;
				if(member!= null && member.getTeacherId() == kch.getTeacherId()){
					quanxian = true;
				}
				if(member!= null && member.getRoleId() == 1){
					quanxian = true;
				}
				obj.setQuanxian(quanxian);
				////////////////////////////////////
				
				obj.setKecheng(kch);
				obj.setXueqi(kch.getXueqi());
				obj.setTeacher(kch.getTeacher());
			
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, total);
		map.put(Constant.DATA, list);
		return map;
	}

	/**
	 * 得到课程下所有需要上传的文件条目，没有则创建
	 * @param kechengId
	 * @param member
	 * @return
	 */
	public static Map<String, Object> getKechengJiaoxue(int kechengId, Member member) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, 0);
		
		Kecheng kecheng = KechengServiceImpl.retrieveByPK(kechengId);
		if(kecheng == null || StringUtils.isBlank(kecheng.getFileUploadFlags())){
			map.put(Constant.DATA, new ArrayList<JiaoxueFile>());
			return map;
		}
		
		//删除多余的文件
		deleteInvalidItems(kecheng);
		//得到现有的flag
		Set<Integer> set = getKechengJiaoxueFlagList(kecheng);
		//创建没有的flag
		createKechengFile(kecheng, set);
		//查询最终记录
		List<JiaoxueFile> kechengFileList = getKechengJiaoxue(kecheng);
		
		//操作权限判断，管理员及作者自己有权限
		boolean quanxian = false;
		if(member!= null && member.getTeacherId() == kecheng.getTeacherId()){
			quanxian = true;
		}
		if(member!= null && member.getRoleId() == 1){
			quanxian = true;
		}
		
		for(JiaoxueFile jxf : kechengFileList){
			jxf.setQuanxian(quanxian);
		}
		
		map.put(Constant.TOTAL, kechengFileList.size());
		map.put(Constant.DATA, kechengFileList);
		return map;
	}
	
	private static void deleteInvalidItems(Kecheng kecheng) {
		String sql = " delete from " + JiaoxueFilePeer.TABLE_NAME + " "
				+ " where " + JiaoxueFilePeer.KECHENG_ID + "=" + kecheng.getId()
				+ " and " + JiaoxueFilePeer.FILE_FLAG + " not in (" + kecheng.getFileUploadFlags() + ") ";
		
		try {
			BasePeer.executeStatement(sql);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
	}

	public static void createKechengFile(Kecheng kecheng,Set<Integer> kechengFileList) {
		List<Integer> flags = kecheng.getFileFlags();
		try {
			for(Integer f : flags){
				if(kechengFileList.contains(f)){
					continue;
				}
				JiaoxueFile jxf = new JiaoxueFile();
				jxf.setXueqiId(kecheng.getXueqiId());
				jxf.setTeacherId(kecheng.getTeacherId());
				jxf.setKechengId(kecheng.getId());
				jxf.setFileFlag(f);
				jxf.setFileScore(Constant.fileFlagMap.get(f).getScore());
				JiaoxueFilePeer.doInsert(jxf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Set<Integer> getKechengJiaoxueFlagList(Kecheng kecheng){
		StringBuffer sbr = new StringBuffer();
		
		sbr.append(" select ").append(JiaoxueFilePeer.FILE_FLAG);
		sbr.append(" from ").append(JiaoxueFilePeer.TABLE_NAME);
		sbr.append(" where ").append(JiaoxueFilePeer.FILE_FLAG)
			.append(" in (").append(kecheng.getFileUploadFlags()).append(") ")
		   .append(" and ").append(JiaoxueFilePeer.KECHENG_ID).append(" = ").append(kecheng.getId());
		
		Set<Integer> set = new HashSet<Integer>();
		try {
			List<Record> searchList = BasePeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				set.add(row.getValue(JiaoxueFilePeer.FILE_FLAG).asInt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return set;
	}
	
	public static void createKechengFileList(Kecheng kecheng) {
		List<Integer> flags = kecheng.getFileFlags();
		try {
			for(int f : flags){
				JiaoxueFile jxf = new JiaoxueFile();
				jxf.setKechengId(kecheng.getId());
				jxf.setFileFlag(f);
				jxf.setFileScore(Constant.fileFlagMap.get(f).getScore());
				JiaoxueFilePeer.doInsert(jxf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<JiaoxueFile> getKechengJiaoxue(Kecheng kecheng){
		StringBuffer sbr = new StringBuffer();
		
		sbr.append(" select ").append(JiaoxueFilePeer.TABLE_NAME).append(".* ")
					.append(",").append(KechengPeer.NAME)
					.append(",").append(TeacherPeer.NAME)
					.append(",").append(XueqiPeer.NAME);
		
		sbr.append(" from ").append(JiaoxueFilePeer.TABLE_NAME);
		sbr.append(" left join ").append(KechengPeer.TABLE_NAME).append(" on ").append(KechengPeer.ID).append("=").append(JiaoxueFilePeer.KECHENG_ID);
		sbr.append(" left join ").append(XueqiPeer.TABLE_NAME).append(" on ").append(XueqiPeer.ID).append("=").append(KechengPeer.XUEQI_ID);
		sbr.append(" left join ").append(TeacherPeer.TABLE_NAME).append(" on ").append(TeacherPeer.ID).append("=").append(KechengPeer.TEACHER_ID);
		
		sbr.append(" where ").append(JiaoxueFilePeer.FILE_FLAG)
			.append(" in (").append(kecheng.getFileUploadFlags()).append(") ")
		   .append(" and ").append(JiaoxueFilePeer.KECHENG_ID).append(" = ").append(kecheng.getId());
		
		List<JiaoxueFile> list = new ArrayList<JiaoxueFile>();
		try {
			List<Record> searchList = JiaoxueFilePeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				JiaoxueFile obj = JiaoxueFilePeer.row2Object(row, 1, JiaoxueFilePeer.getOMClass());
				
				Kecheng kc = new Kecheng();
				kc.setName(row.getValue(KechengPeer.NAME).asString());
				
				Xueqi xq = new Xueqi();
				xq.setName(row.getValue(XueqiPeer.NAME).asString());
				
				Teacher tc = new Teacher();
				tc.setName(row.getValue(TeacherPeer.NAME).asString());
				
				JiaoxueFileScore flag = Constant.fileFlagMap.get(obj.getFileFlag());
				obj.setJiaoxueFileScore(flag);
				
				obj.setKecheng(kc);
				obj.setXueqi(xq);
				obj.setTeacher(tc);
			
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static JiaoxueFile getById(int id) {
		try {
			return JiaoxueFilePeer.retrieveByPK(id);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Boolean clearFile(int id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update ").append(JiaoxueFilePeer.TABLE_NAME)
			.append(" set ").append(JiaoxueFilePeer.NAME).append("='' ")
			.append(" , ").append(JiaoxueFilePeer.SAVE_NAME).append("='' ")
			.append(" , ").append(JiaoxueFilePeer.INTRO).append("='' ")
			.append(" , ").append(JiaoxueFilePeer.FILE_SIZE).append("=0 ")
			.append(" , ").append(JiaoxueFilePeer.MEMBER_ID).append("=0 ")
			.append(" , ").append(JiaoxueFilePeer.MEMBER_NAME).append("='' ")
			.append(" , ").append(JiaoxueFilePeer.UPTIME).append("=null ");
		sql.append(" where ").append(JiaoxueFilePeer.ID).append("=").append(id);
		try {
			return JiaoxueFilePeer.executeStatement(sql.toString()) > 0;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<JiaoxueFile> getKechengFiles(int kechengId) {
		Criteria c = new Criteria();
		c.add(JiaoxueFilePeer.KECHENG_ID, kechengId);
		try {
			return JiaoxueFilePeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

}
