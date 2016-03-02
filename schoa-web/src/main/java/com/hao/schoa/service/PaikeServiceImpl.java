package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.container.ContainerKechengbiao;
import com.hao.schoa.container.ContainerPaike;
import com.hao.schoa.po.ClassesKecheng;
import com.hao.schoa.po.ClassesKechengPeer;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.SchoaUtil;
import com.workingdogs.village.Record;

public class PaikeServiceImpl {

	/**
	 * 班级已经排课的记录
	 * @param classesId
	 * @return
	 */
	public static Map<Date, ContainerPaike> getPaiKeMap(int classesId) {
		String sql = "SELECT * FROM " + ClassesKechengPeer.TABLE_NAME
				+ " WHERE " + ClassesKechengPeer.CLASSES_ID + "=" + classesId
				+ " ORDER BY " + ClassesKechengPeer.KECHENG_START + ","
				+ ClassesKechengPeer.WEEK;
		Map<Date, ContainerPaike> map = new LinkedHashMap<Date, ContainerPaike>();
		try {
			List<Record> ls = ClassesKechengPeer.executeQuery(sql);
			for (int i = 0; i < ls.size(); i++) {
				Record row = ls.get(i);
				ClassesKecheng obj = ClassesKechengPeer.row2Object(row, 1, ClassesKechengPeer.getOMClass());
				Date s = obj.getKechengStart();
				ContainerPaike paike = null;
				if (map.containsKey(s)) {
					paike = map.get(s);
				} else {
					paike = new ContainerPaike();
					map.put(s, paike);
				}
				paike.setStartDate(s);
				paike.setStartStr(Constant.HMDATE.format(s));
				paike.setEndDate(obj.getKechengEnd());
				paike.setEndStr(Constant.HMDATE.format(obj.getKechengEnd()));
				int[] arr = paike.getWks();
				int[] pkArr = paike.getPaiKeId();
				arr[obj.getWeek()] = obj.getKechengId();
				pkArr[obj.getWeek()] = obj.getId();
				paike.setWks(arr);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static boolean deletePaike(int classesId){
		String sql = " delete from " + ClassesKechengPeer.TABLE_NAME 
				+ " where " + ClassesKechengPeer.CLASSES_ID + "=" + classesId;
		try {
			ClassesKechengPeer.executeStatement(sql);
			return true;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 查询班级下安排的课程
	 * @param classesId 班级id
	 * @param teacherId 教师id
	 * @return
	 */
	public static List<Kecheng> getClassesKecheng(int classesId, int teacherId) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(KechengPeer.TABLE_NAME).append(".* ");
		sbr.append(" from ").append(ClassesKechengPeer.TABLE_NAME);
		sbr.append(" left join ").append(KechengPeer.TABLE_NAME).append(" on ").append(KechengPeer.ID).append("=").append(ClassesKechengPeer.KECHENG_ID);
		sbr.append(" where ").append(ClassesKechengPeer.CLASSES_ID).append(" = ").append(classesId);
		if(teacherId > 0){
			sbr.append(" and ").append(KechengPeer.TEACHER_ID).append(" = ").append(teacherId);
		}
		sbr.append(" group by ").append(ClassesKechengPeer.KECHENG_ID);
		
		List<Kecheng> list = new ArrayList<Kecheng>();
		try {
			List<Record> searchList = ClassesKechengPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Kecheng obj = KechengPeer.row2Object(row, 1, KechengPeer.getOMClass());
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询班级下安排的课程
	 * @param classesId 班级id
	 * @return
	 */
	public static List<Kecheng> getClassesKecheng(int classesId) {
		return getClassesKecheng(classesId, 0);
	}
	
	/**
	 * 某课程每周课时数
	 * @param classesId
	 * @param kechengId
	 * @return
	 */
	public static int getCountKeshi(int classesId, int kechengId){
		Criteria c = new Criteria();
		c.add(ClassesKechengPeer.CLASSES_ID, classesId);
		c.add(ClassesKechengPeer.KECHENG_ID, kechengId);
		try {
			List<ClassesKecheng> ls = ClassesKechengPeer.doSelect(c);
			if(ls != null && ls.size() > 0){
				return ls.size();
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 查询班级课时数
	 * @param classesId 班级id
	 * @param kechengId 课程id，小于或等于0，表所有课程
	 * @param weekIndexs 星期，格式(1，2，3)
	 * @return
	 */
	public static int countClassKeshi(int classesId, int kechengId, String weekIndexs) {
		StringBuffer sbr = new StringBuffer();
		sbr.append("select count(*) from ").append(ClassesKechengPeer.TABLE_NAME)
			.append(" where ").append(ClassesKechengPeer.CLASSES_ID).append("=").append(classesId);
		
		if(kechengId > 0){
			sbr.append(" and ").append(ClassesKechengPeer.KECHENG_ID).append("=").append(kechengId);
		}
		if(StringUtils.isNotBlank(weekIndexs)){
			sbr.append(" and ").append(ClassesKechengPeer.WEEK).append(" in ").append(weekIndexs);
		}
		
		try {
			List<Record> ls = BasePeer.executeQuery(sbr.toString());
			if(ls != null && ls.size() > 0){
				return ls.get(0).getValue(1).asInt();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 查询班级课程表
	 * @param classesId
	 * @return
	 */
	public static ContainerKechengbiao searcheKechengbiao(int classesId){
		ContainerKechengbiao kechengbiao = new ContainerKechengbiao();
		List<ClassesKecheng> all = getKechengs(classesId);
		if(all == null ){
			return kechengbiao;
		}
		
		//将数据组装到ContainerKechengbiao对象
		for(ClassesKecheng ck : all){
			if(!kechengbiao.getWeekIndexList().contains(ck.getWeek())){
				kechengbiao.getWeekIndexList().add(ck.getWeek());
			}
			
			String time = Constant.HMDATE.format(ck.getKechengStart())+"-"+Constant.HMDATE.format(ck.getKechengEnd());
			if(!kechengbiao.getTimeList().contains(time)){
				kechengbiao.getTimeList().add(time);
			}
			
			ck.setTime(time);
			kechengbiao.getPaikeMap().put(ck, ck);
		}
		
		return kechengbiao;
	}
	
	/**
	 * 查询班级下所有排课
	 */
	public static List<ClassesKecheng> getKechengs(int classesId){
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(ClassesKechengPeer.TABLE_NAME).append(".* ");
		sbr.append(",").append(TeacherPeer.NAME);
		sbr.append(",").append(KechengPeer.NAME);
		sbr.append(" from ").append(ClassesKechengPeer.TABLE_NAME);
		sbr.append(" left join ").append(KechengPeer.TABLE_NAME).append(" on ").append(KechengPeer.ID).append("=").append(ClassesKechengPeer.KECHENG_ID);
		sbr.append(" left join ").append(TeacherPeer.TABLE_NAME).append(" on ").append(TeacherPeer.ID).append("=").append(KechengPeer.TEACHER_ID);
		sbr.append(" where ").append(ClassesKechengPeer.CLASSES_ID).append(" = ").append(classesId);
		sbr.append(" order by ").append(ClassesKechengPeer.KECHENG_START).append(",").append(ClassesKechengPeer.WEEK);
		
		List<ClassesKecheng> list = new ArrayList<ClassesKecheng>();
		try {
			List<Record> searchList = ClassesKechengPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				ClassesKecheng obj = ClassesKechengPeer.row2Object(row, 1, ClassesKechengPeer.getOMClass());
				obj.setKechengName(row.getValue(KechengPeer.NAME).asString());
				obj.setTeacherName(row.getValue(TeacherPeer.NAME).asString());
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 验证课程排课时间是否冲突
	 * @param classesId
	 * @param week
	 * @param kechengId
	 * @param kechengStart
	 * @param kechengEnd
	 * @return
	 */
	public static String verifyPaikeTime(int classesId, int week, int kechengId, String kechengStart, String kechengEnd){
		String start = SchoaUtil.pinPaikeTimeStr(kechengStart);
		String end = SchoaUtil.pinPaikeTimeStr(kechengEnd);
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select ").append(KechengPeer.NAME)
			.append(",").append(TeacherPeer.NAME)
			.append(",").append(TeacherPeer.PHONE)
			.append(" from ").append(ClassesKechengPeer.TABLE_NAME)
			.append(" left join ").append(KechengPeer.TABLE_NAME)
				.append(" on ").append(KechengPeer.ID).append("=").append(ClassesKechengPeer.KECHENG_ID)
			.append(" left join ").append(TeacherPeer.TABLE_NAME)
				.append(" on ").append(TeacherPeer.ID).append("=").append(KechengPeer.TEACHER_ID)
			.append(" where ").append(ClassesKechengPeer.WEEK).append("=").append(week)
			.append(" and ").append(ClassesKechengPeer.CLASSES_ID).append("!=").append(classesId)
			.append(" and ").append(KechengPeer.ID).append("=").append(kechengId)
			.append(" and ").append(ClassesKechengPeer.KECHENG_START).append("='").append(start).append("' ")
			.append(" and ").append(ClassesKechengPeer.KECHENG_END).append("='").append(end).append("' ");
		
		try {
			List<Record> searchList = BasePeer.executeQuery(sql.toString());
			if(searchList == null || searchList.size() < 1){
				return null;
			}
			
			Record rec = searchList.get(0);
			return "排课时间冲突！\n"
					+ "课程：" + rec.getValue(KechengPeer.NAME).asString() + "\n" 
					+ "教师：" + rec.getValue(TeacherPeer.NAME).asString() + 
						"（TEL：" + rec.getValue(TeacherPeer.PHONE).asString() + "）\n" 
					+ "排课时间：" + Constant.WEEKMAP.get(week) + "(" + kechengStart + "~" + kechengEnd + ")";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "内部错误";		
	}

	
	public static boolean updatePaikeKecheng(int paikeId,int oldKechengId,int newKechengId){
		String sql = " update " + ClassesKechengPeer.TABLE_NAME + " set " 
					+ ClassesKechengPeer.KECHENG_ID + "=" + newKechengId 
					+ " where " + ClassesKechengPeer.ID + "=" + paikeId
					+ " and " + ClassesKechengPeer.KECHENG_ID + "=" + oldKechengId;
		
		try {
			BasePeer.executeStatement(sql);
			return true;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return false;
	}
}
