package com.hao.schoa.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.container.ContainerPaikeModel;
import com.hao.schoa.container.ContainerQueqinInfo;
import com.hao.schoa.container.ContainerStudentQueqin;
import com.hao.schoa.po.ClassesKecheng;
import com.hao.schoa.po.ClassesKechengPeer;
import com.hao.schoa.po.ClassesPeer;
import com.hao.schoa.po.Kaoqin;
import com.hao.schoa.po.KaoqinPeer;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.SchoaUtil;
import com.workingdogs.village.Record;

public class KaoqinServiceImpl {
	
	/**
	 * 获取班级排课Map
	 * @param classesId
	 * @return Map : key-星期(0-6)	value-排好的课程列表
	 */
	public static Map<Integer,List<ClassesKecheng>> getClassesKechengMap(int classesId){
		List<ClassesKecheng> list = getClassesKechengList(classesId);
		Map<Integer,List<ClassesKecheng>> map = new HashMap<Integer,List<ClassesKecheng>>();
		for(ClassesKecheng ck : list){
			if(!map.containsKey(ck.getWeek())){
				map.put(ck.getWeek(), new ArrayList<ClassesKecheng>());
			}
			map.get(ck.getWeek()).add(ck);
		}
		return map;
	}
	
	/**
	 * 获取班级排课List
	 * @param classesId
	 * @return
	 */
	public static List<ClassesKecheng> getClassesKechengList(int classesId){
		List<ClassesKecheng> list = new ArrayList<ClassesKecheng>();
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(ClassesKechengPeer.TABLE_NAME).append(".* ")
					.append(",").append(KechengPeer.NAME)
					.append(",").append(TeacherPeer.ID)
					.append(",").append(TeacherPeer.NAME);
		
		sbr.append(" from ").append(ClassesKechengPeer.TABLE_NAME);
		sbr.append(" left join ").append(KechengPeer.TABLE_NAME).append(" on ").append(KechengPeer.ID).append("=").append(ClassesKechengPeer.KECHENG_ID);
		sbr.append(" left join ").append(TeacherPeer.TABLE_NAME).append(" on ").append(TeacherPeer.ID).append("=").append(KechengPeer.TEACHER_ID);
		
		sbr.append(" where  ").append(ClassesKechengPeer.CLASSES_ID).append("=").append(classesId);
		sbr.append(" order by  ").append(ClassesKechengPeer.KECHENG_START);
		
		try {
			List<Record> searchList = ClassesKechengPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				ClassesKecheng obj = ClassesKechengPeer.row2Object(row, 1, ClassesKechengPeer.getOMClass());
				
				obj.setTeacherId(row.getValue(TeacherPeer.ID).asInt());
				obj.setTeacherName(row.getValue(TeacherPeer.NAME).asString());
				obj.setKechengName(row.getValue(KechengPeer.NAME).asString());
				obj.setStart(Constant.HMDATE.format(obj.getKechengStart()));
				obj.setEnd(Constant.HMDATE.format(obj.getKechengEnd()));
			
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 周一到周六排课模型
	 * @param start
	 * @param end
	 * @return
	 */
	public static Map<Integer,ContainerPaikeModel> getPaikeModelMap(String start,String end){
		try {
			return getPaikeModelMap(Constant.DATE.parse(start),Constant.DATE.parse(end));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return key－－周几，value－－paikemodel
	 */
	public static Map<Integer,ContainerPaikeModel> getPaikeModelMap(Date start,Date end){
		Map<Integer,ContainerPaikeModel> map = new LinkedHashMap<Integer, ContainerPaikeModel>();
		
		Date tmp = start;
		while(true){
			int index = SchoaUtil.getWeekIndex(tmp)-1;
			index = index==-1?6:index;
			map.put(index, new ContainerPaikeModel(index,Constant.WEEKMAP.get(index),Constant.DATE.format(tmp)));
			if(tmp.equals(end)){
				break;
			}
			tmp = SchoaUtil.addDate(tmp,1);
		}
		return map;
	}

	/**
	 * 加载学生考勤
	 * @param classes
	 * @param start
	 * @param end
	 * @return
	 */
	public static Map<String, String> getKaoqin(int classes, String start, String end) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(KaoqinPeer.TABLE_NAME).append(".* ");
		
		sbr.append(" from ").append(KaoqinPeer.TABLE_NAME);
		sbr.append(" left join ").append(ClassesKechengPeer.TABLE_NAME).append(" on ").append(ClassesKechengPeer.ID).append("=").append(KaoqinPeer.CLASSES_KECHENG_ID);
		
		sbr.append(" where 1=1 ");
		if(classes > 0){
			sbr.append(" and ").append(ClassesKechengPeer.CLASSES_ID).append(" = ").append(classes);
		}
		
		if(StringUtils.isNotBlank(start)){
			sbr.append(" and ").append(KaoqinPeer.DAY).append(" >= '").append(start).append("' ");
		}
		
		if(StringUtils.isNotBlank(end)){
			sbr.append(" and ").append(KaoqinPeer.DAY).append(" <= '").append(end).append("' ");
		}
		
		Map<String,String> kaoqinMap = new HashMap<String,String>();
		try {
			List<Record> searchList = ClassesPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Kaoqin obj = KaoqinPeer.row2Object(row, 1, KaoqinPeer.getOMClass());
				String kq = Constant.kaoqinTypeMap.get(obj.getKaoqin());
				kaoqinMap.put("k_"+obj.getStudentId()+"_"+obj.getClassesKechengId(), kq.substring(kq.indexOf(":")+1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kaoqinMap;
	}
	
	public static Kaoqin getKaoqin(int paikeId, int studentId, String day){
		Criteria c = new Criteria();
		c.add(KaoqinPeer.CLASSES_KECHENG_ID, paikeId);
		c.add(KaoqinPeer.STUDENT_ID, studentId);
		c.add(KaoqinPeer.DAY, day);
		try {
			List<Kaoqin> ls = KaoqinPeer.doSelect(c);
			if(ls != null && ls.size() > 0){
				return ls.get(0);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 报表 － 查询学生缺勤情况
	 * @param classesId
	 * @param studentId
	 * @return key－－kechengId,value －－ 缺勤－缺勤数的list
	 */
	public static Map<Integer, List<ContainerStudentQueqin>> searchStudentQueqinMap(int classesId, int studentId) {
		Map<Integer,List<ContainerStudentQueqin>> map = null;
		StringBuffer sb = new StringBuffer();
		sb.append(" select ")
			.append(ClassesKechengPeer.KECHENG_ID)
			.append(",").append(KaoqinPeer.KAOQIN)
			.append(",").append(KechengPeer.NAME)
			.append(",count(").append(KaoqinPeer.KAOQIN).append(")")
			.append(",").append(KechengPeer.ID)
			.append(" from ").append(KaoqinPeer.TABLE_NAME)
			.append(" left join ").append(ClassesKechengPeer.TABLE_NAME)
			.append(" ON ").append(ClassesKechengPeer.ID).append("=").append(KaoqinPeer.CLASSES_KECHENG_ID)
			.append(" left join ").append(KechengPeer.TABLE_NAME)
			.append(" ON ").append(KechengPeer.ID).append("=").append(ClassesKechengPeer.KECHENG_ID)
			.append(" where ").append(KaoqinPeer.KAOQIN).append(" > 0 ")
			.append(" and ").append(ClassesKechengPeer.CLASSES_ID).append("=").append(classesId)
			.append(" and ").append(KaoqinPeer.STUDENT_ID).append("=").append(studentId)
			.append(" group by ").append(ClassesKechengPeer.KECHENG_ID)
			.append(" , ").append(KaoqinPeer.KAOQIN);
		
		try {
			List<Record> list = BasePeer.executeQuery(sb.toString());
			if(list != null){
				map = new HashMap<Integer,List<ContainerStudentQueqin>>();
				for(Record record : list){
					int kechengId = record.getValue(1).asInt();
					int kaoqin = record.getValue(2).asInt();
					String kechengName = record.getValue(3).asString();
					int queqin = record.getValue(4).asInt();
					ContainerStudentQueqin obj = new ContainerStudentQueqin(kechengId,kaoqin,queqin,kechengName);
					if(!map.containsKey(kechengId)){
						map.put(kechengId, new ArrayList<ContainerStudentQueqin>());
					}
					map.get(kechengId).add(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;	
	}
	
//	select *
//	from kaoqin k
//	left join classes_kecheng ck on ck.id=k.classes_kecheng_id
//	where ck.classes_id = 1
//	group by ck.kecheng_id
	
	/**
	 * 判断班级下是否有考勤，有－不能修改排课，否则可以
	 * @param classesId
	 * @return true-有排课，false－没有排课
	 */
	public static boolean isHaveKaoqin(int classesId) throws Exception{
		boolean res = true;
		StringBuffer sb = new StringBuffer();
		sb.append(" select count(*) ")
			.append(" from ").append(KaoqinPeer.TABLE_NAME)
			.append(" left join ").append(ClassesKechengPeer.TABLE_NAME)
			.append(" ON ").append(ClassesKechengPeer.ID).append("=").append(KaoqinPeer.CLASSES_KECHENG_ID)
			.append(" where ").append(KaoqinPeer.KAOQIN).append(" > 0 ")
			.append(" and ").append(ClassesKechengPeer.CLASSES_ID).append("=").append(classesId);
		
		List<Record> list = BasePeer.executeQuery(sb.toString());
		if(list != null){
			return list.get(0).getValue(1).asInt() > 0;
		}
		return res;
	}
	/**
	 * 判断班级下是否有考勤
	 * @param classesIds
	 * @return
	 * @throws Exception
	 */
	public static boolean isHaveKaoqin(String classesIds) throws Exception{
		boolean res = true;
		StringBuffer sb = new StringBuffer();
		sb.append(" select count(*) ")
		.append(" from ").append(KaoqinPeer.TABLE_NAME)
		.append(" left join ").append(ClassesKechengPeer.TABLE_NAME)
		.append(" ON ").append(ClassesKechengPeer.ID).append("=").append(KaoqinPeer.CLASSES_KECHENG_ID)
		.append(" where ").append(KaoqinPeer.KAOQIN).append(" > 0 ")
		.append(" and ").append(ClassesKechengPeer.CLASSES_ID).append(" in (").append(classesIds).append(") ");
		
		List<Record> list = BasePeer.executeQuery(sb.toString());
		if(list != null){
			return list.get(0).getValue(1).asInt() > 0;
		}
		return res;
	}
	
	/**
	 * 查询学生在某个班级的出勤情况
	 * @param classesId
	 * @param studentId
	 * @param startDay
	 * @param endDay
	 * @return key:课程id，value：学生对本课程的缺勤信息
	 */
	public static Map<Integer,ContainerQueqinInfo> getStudentKaoqinInfo(int classesId,int studentId,String startDay,String endDay){
//		SELECT k.student_id,ck.`kecheng_id`,k.kaoqin,count(k.id)
//		FROM kaoqin k
//		LEFT JOIN classes_kecheng ck ON ck.id=k.classes_kecheng_id
//		WHERE ck.classes_id = 2
//		AND k.student_id = 35
//		AND k.day >= '' AND k.day <= ''
//		AND k.`kaoqin` > 0
//		GROUP BY ck.kecheng_id,k.kaoqin
		Map<Integer,ContainerQueqinInfo> map = new HashMap<Integer, ContainerQueqinInfo>();
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(ClassesKechengPeer.KECHENG_ID)
			.append(",").append(KaoqinPeer.KAOQIN)
			.append(",count(1) as count")
			.append(" from ").append(KaoqinPeer.TABLE_NAME)
			.append(" left join ").append(ClassesKechengPeer.TABLE_NAME)
			.append(" on ").append(ClassesKechengPeer.ID).append("=").append(KaoqinPeer.CLASSES_KECHENG_ID)
			.append(" where ").append(ClassesKechengPeer.CLASSES_ID).append("=").append(classesId)
			.append(" and ").append(KaoqinPeer.STUDENT_ID).append("=").append(studentId)
			.append(" and ").append(KaoqinPeer.KAOQIN).append(">0")
			.append(" and ").append(KaoqinPeer.DAY).append(">= '").append(startDay).append("' ")
			.append(" and ").append(KaoqinPeer.DAY).append("<= '").append(endDay).append("' ")
			.append(" group by ").append(ClassesKechengPeer.KECHENG_ID).append(",").append(KaoqinPeer.KAOQIN);
		
		
		try {
			List<Record> list = BasePeer.executeQuery(sbr.toString());
			if(list != null && !list.isEmpty()){
				for(Record rec : list){
					int key = rec.getValue(1).asInt();
					int keshi = rec.getValue(3).asInt() * 2;
					String queqin = Constant.kaoqinTypeMap.get(rec.getValue(2).asInt()).split(":")[0];
					
					if(map.get(key) == null){
						ContainerQueqinInfo info = new ContainerQueqinInfo();
						info.setQueqinInfo(queqin + keshi + "课时");
						info.setTotalQueqin(keshi);
						map.put(key, info);
					}else{
						ContainerQueqinInfo info = map.get(key);
						info.setQueqinInfo(info.getQueqinInfo() + ";" + queqin + keshi + "课时");
						info.setTotalQueqin(info.getTotalQueqin() + keshi);
						map.put(key, info);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
