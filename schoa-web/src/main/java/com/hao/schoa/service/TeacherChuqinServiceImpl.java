package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.ClassesKecheng;
import com.hao.schoa.po.ClassesKechengPeer;
import com.hao.schoa.po.ClassesPeer;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.TeacherKaoqin;
import com.hao.schoa.po.TeacherKaoqinPeer;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.DataSetException;
import com.workingdogs.village.Record;

/**
 * 教师上课出勤
 * @author haoguowei
 *
 */
public class TeacherChuqinServiceImpl {

	public static TeacherKaoqin getChuqin(int paikeId, int teacherId, String day) {
		Criteria c = new Criteria();
		c.add(TeacherKaoqinPeer.CLASSES_KECHENG_ID, paikeId);
		c.add(TeacherKaoqinPeer.TEACHER_ID, teacherId);
		c.add(TeacherKaoqinPeer.DAY, day);
		try {
			List<TeacherKaoqin> ls = TeacherKaoqinPeer.doSelect(c);
			if(ls != null && ls.size() > 0){
				return ls.get(0);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<String, String> getKaoqin(int classes, String start, String end) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(TeacherKaoqinPeer.TABLE_NAME).append(".* ");
		
		sbr.append(" from ").append(TeacherKaoqinPeer.TABLE_NAME);
		sbr.append(" left join ").append(ClassesKechengPeer.TABLE_NAME).append(" on ").append(ClassesKechengPeer.ID).append("=").append(TeacherKaoqinPeer.CLASSES_KECHENG_ID);
		
		sbr.append(" where 1=1 ");
		if(classes > 0){
			sbr.append(" and ").append(ClassesKechengPeer.CLASSES_ID).append(" = ").append(classes);
		}
		
		if(StringUtils.isNotBlank(start)){
			sbr.append(" and ").append(TeacherKaoqinPeer.DAY).append(" >= '").append(start).append("' ");
		}
		
		if(StringUtils.isNotBlank(end)){
			sbr.append(" and ").append(TeacherKaoqinPeer.DAY).append(" <= '").append(end).append("' ");
		}
		
		Map<String,String> kaoqinMap = new HashMap<String,String>();
		try {
			List<Record> searchList = TeacherKaoqinPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				TeacherKaoqin obj = TeacherKaoqinPeer.row2Object(row, 1, TeacherKaoqinPeer.getOMClass());
				
				String val = "";
				if(obj.getKaoqin() != -2){
					val = Constant.teacherChuqinMap.get(obj.getKaoqin());
					if(StringUtils.isNotBlank(obj.getKaoqinRemark())){
						val += "<br/><span style='color: #999;'>" + obj.getKaoqinRemark() + "</span>";
					}
				}
				kaoqinMap.put("k_"+obj.getTeacherId()+"_"+obj.getClassesKechengId(), val);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kaoqinMap;
	}

	/**
	 * 查询教师缺勤课时
	 * @param teacherId
	 * @param banjiId
	 * @param kechengId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getQueqinKeshi(int teacherId, int banjiId, int kechengId, Date startDate, Date endDate) {
		
		String sql = "SELECT count(*) "
				+ " FROM  " + TeacherKaoqinPeer.TABLE_NAME
				+ " left join  " + ClassesKechengPeer.TABLE_NAME + " on " + ClassesKechengPeer.ID + " = " + TeacherKaoqinPeer.CLASSES_KECHENG_ID
				+ " WHERE  " + TeacherKaoqinPeer.KAOQIN + " > 0"
				+ " AND  " + TeacherKaoqinPeer.TEACHER_ID + " = " + teacherId
				+ " AND  " + ClassesKechengPeer.CLASSES_ID + " = " + banjiId
				+ " AND  " + ClassesKechengPeer.KECHENG_ID + " = " + kechengId
				+ " AND  " + TeacherKaoqinPeer.DAY + " >= '" + Constant.DATE.format(startDate) + "' "
				+ " AND  " + TeacherKaoqinPeer.DAY + " <= '" + Constant.DATE.format(endDate) + "' ";
		
		List<Record> ls = null;
		int score = 0;
		try {
			ls = BasePeer.executeQuery(sql);
			if(ls != null && !ls.isEmpty()){
				score = ls.get(0).getValue(1).asInt();
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}catch (DataSetException e) {
			e.printStackTrace();
		}
		return score * 2;
	}
	
	/**
	 * 得到出勤或缺勤对应的次数
	 * @param teacherId
	 * @param banjiId
	 * @param kechengId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static Map<Integer,Integer> getChuqinTimes(int teacherId, int banjiId, int kechengId, Date startDate, Date endDate) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		String sql = "SELECT kaoqin,count(*) "
				+ " FROM  " + TeacherKaoqinPeer.TABLE_NAME
				+ " left join  " + ClassesKechengPeer.TABLE_NAME + " on " + ClassesKechengPeer.ID + " = " + TeacherKaoqinPeer.CLASSES_KECHENG_ID
				+ " WHERE  " + TeacherKaoqinPeer.TEACHER_ID + " = " + teacherId
				+ " AND  " + ClassesKechengPeer.CLASSES_ID + " = " + banjiId
				+ " AND  " + ClassesKechengPeer.KECHENG_ID + " = " + kechengId
				+ " AND  " + TeacherKaoqinPeer.DAY + " >= '" + Constant.DATE.format(startDate) + "' "
				+ " AND  " + TeacherKaoqinPeer.DAY + " <= '" + Constant.DATE.format(endDate) + "' "
				+ " group by " + TeacherKaoqinPeer.KAOQIN;
		
		try {
			List<Record> ls = BasePeer.executeQuery(sql);
			if(ls != null && !ls.isEmpty()){
				for (int i = 0; i < ls.size(); i++) {
					Record row = ls.get(i);
					int flag = row.getValue(1).asInt();
					int count = row.getValue(2).asInt();
					map.put(flag, count);
				}
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}catch (DataSetException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 查询班级某节课所有出勤信息
	 * select k.*,t.name
	 * from teacher_kaoqin k
	 * left join classes_kecheng kc on kc.id = k.classes_kecheng_id
	 * left join teacher t on t.id=k.teacher_id
	 * where kc.classes_id=
	 * and kc.kecheng_id=
	 * order by day
	 * @param banjiId
	 * @param kechengId
	 * @return
	 */
	public static List<TeacherKaoqin> getKechengChuqinInfo(int banjiId,int kechengId){
		List<TeacherKaoqin> resultList = new ArrayList<TeacherKaoqin>();
		StringBuffer sbr = new StringBuffer();
		
		sbr.append("select ").append(TeacherKaoqinPeer.TABLE_NAME).append(".*")
			.append(",").append(TeacherPeer.NAME)
			.append(",").append(KechengPeer.NAME)
			.append(",").append(ClassesPeer.NAME)
			.append(",").append(ClassesKechengPeer.KECHENG_START)
			.append(",").append(ClassesKechengPeer.KECHENG_END)
			.append(" from ").append(TeacherKaoqinPeer.TABLE_NAME);
		
		sbr.append(" left join ").append(ClassesKechengPeer.TABLE_NAME).append(" on ").append(ClassesKechengPeer.ID).append("=").append(TeacherKaoqinPeer.CLASSES_KECHENG_ID);
		sbr.append(" left join ").append(TeacherPeer.TABLE_NAME).append(" on ").append(TeacherPeer.ID).append("=").append(TeacherKaoqinPeer.TEACHER_ID);
		sbr.append(" left join ").append(KechengPeer.TABLE_NAME).append(" on ").append(KechengPeer.ID).append("=").append(ClassesKechengPeer.KECHENG_ID);
		sbr.append(" left join ").append(ClassesPeer.TABLE_NAME).append(" on ").append(ClassesPeer.ID).append("=").append(ClassesKechengPeer.CLASSES_ID);
		
		
		sbr.append(" where ").append(ClassesKechengPeer.CLASSES_ID).append("=").append(banjiId);
		sbr.append(" and ").append(ClassesKechengPeer.KECHENG_ID).append("=").append(kechengId);
		
		sbr.append(" order by ").append(TeacherKaoqinPeer.DAY);
		
		try {
			List<Record> ls = BasePeer.executeQuery(sbr.toString());
			for (int i = 0; i < ls.size(); i++) {
				Record row = ls.get(i);
				TeacherKaoqin obj = TeacherKaoqinPeer.row2Object(row, 1, TeacherKaoqinPeer.getOMClass());
				
				ClassesKecheng ck = new ClassesKecheng();
				ck.setTeacherName(row.getValue(TeacherPeer.NAME).asString());
				ck.setKechengName(row.getValue(KechengPeer.NAME).asString());
				
				obj.setClassesKecheng(ck);
				
				obj.setBanjiName(row.getValue(ClassesPeer.NAME).asString());
				
				
				String d = Constant.CNDATE.format(obj.getDay());
				String s = Constant.HMDATE.format(row.getValue(ClassesKechengPeer.KECHENG_START).asDate());
				String e = Constant.HMDATE.format(row.getValue(ClassesKechengPeer.KECHENG_END).asDate());
				String dayAndTime = d + "  " + s + "-" + e;
				
				obj.setDayAndTime(dayAndTime);
				obj.setKaoqinInfo(Constant.teacherChuqinMap.get(obj.getKaoqin()));
				
				resultList.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public static Map<String, Object> getKechengChuqinInfoMap(int classesId, int kechengId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TeacherKaoqin> list = getKechengChuqinInfo(classesId,kechengId);
		map.put(Constant.TOTAL, list==null?0:list.size());
		map.put(Constant.DATA, list);
		return map;
	}
}
