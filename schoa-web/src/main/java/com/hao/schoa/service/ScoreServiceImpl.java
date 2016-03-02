package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.ClassesKechengPeer;
import com.hao.schoa.po.KaoqinPeer;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.Score;
import com.hao.schoa.po.ScorePeer;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.SchoaUtil;
import com.workingdogs.village.Record;

public class ScoreServiceImpl {
	
	protected static final Log log = LogFactory.getLog(ScoreServiceImpl.class);

	/**
	 * 学生成绩
	 * @param classes 班级
	 * @param kecheng 课程
	 * @return key 学生id ，value 成绩
	 */
	public static Map<Integer,Score> getStudentScoreMap(int classes, int kecheng) {
		Map<Integer,Score> map = new HashMap<Integer,Score>(30);
		Criteria c = new Criteria();
		if(classes > 0){
			c.add(ScorePeer.CLASS_ID, classes);
		}
		if(kecheng > 0){
			c.add(ScorePeer.KECHENG_ID, kecheng);
		}
		c.addDescendingOrderByColumn(ScorePeer.SC_JUANMIAN);
		try {
			List<Score> scoreList = ScorePeer.doSelect(c);
			if(scoreList != null && scoreList.size() > 0){
				for(Score sc : scoreList){
					map.put(sc.getStudentId(), sc);
				}
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 学生在班级下某一科的成绩
	 * @param classesId
	 * @param studentId
	 * @param kechengId
	 * @return
	 */
	public static Score getStudentScore(int classesId, int studentId, int kechengId) {
		Criteria c = new Criteria();
		c.add(ScorePeer.CLASS_ID, classesId);
		c.add(ScorePeer.STUDENT_ID, studentId);
		c.add(ScorePeer.KECHENG_ID, kechengId);
		try {
			List<Score> ls = ScorePeer.doSelect(c);
			if(ls != null && ls.size() > 0){
				return ls.get(0);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 学生在班级下所有科的成绩
	 * @param classesId
	 * @param studentId
	 * @return key 课程id，value 成绩
	 */
	public static Map<Integer,Score> getStudentScoreKCMap(int classesId, int studentId){
		List<Score> scoreList = getStudentScore(classesId,studentId);
		if(scoreList == null || scoreList.size() == 0){
			return null;
		}
		Map<Integer,Score> map = new HashMap<Integer,Score>();
		for(Score score : scoreList){
			map.put(score.getKechengId(), score);
		}
		return map;
	}
	
	
	/**
	 * 学生在班级下所有科的成绩
	 * @param classesId
	 * @param studentId
	 * @return
	 */
	public static List<Score> getStudentScore(int classesId, int studentId) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(ScorePeer.TABLE_NAME).append(".* ")
						.append(",").append(KechengPeer.NAME);
		
		sbr.append(" from ").append(ScorePeer.TABLE_NAME);
		sbr.append(" left join ").append(KechengPeer.TABLE_NAME)
				.append(" on ").append(KechengPeer.ID).append("=").append(ScorePeer.KECHENG_ID);
		
		sbr.append(" where ").append(ScorePeer.STUDENT_ID).append(" = ").append(studentId);
		sbr.append(" and ").append(ScorePeer.CLASS_ID).append(" = ").append(classesId);
		
		List<Score> list = new ArrayList<Score>();
		try {
			List<Record> searchList = ScorePeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Score obj = ScorePeer.row2Object(row, 1, ScorePeer.getOMClass());
				Kecheng kc = new Kecheng();
				kc.setName(row.getValue(KechengPeer.NAME).asString());
				obj.setKecheng(kc);
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 得到缺勤数
	 * @param startDate
	 * @param endDate
	 * @param classesId
	 * @param studentId
	 * @param kechengId
	 * @return
	 */
	public static int getTotalQueqin(Date startDate,Date endDate,int classesId, int studentId, int kechengId){
		return getTotalQueqin(Constant.DATE.format(startDate),Constant.DATE.format(endDate),classesId,studentId,kechengId);
	}
	
	/**
	 * 得到缺勤数
	 * @param startDay
	 * @param endDay
	 * @param classesId
	 * @param studentId
	 * @param kechengId
	 * @return
	 */
	public static int getTotalQueqin(String startDay, String endDay, int classesId, int studentId, int kechengId) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select count(*) ");
		sbr.append(" from ").append(KaoqinPeer.TABLE_NAME);
		sbr.append(" left join ").append(ClassesKechengPeer.TABLE_NAME)
			.append(" on ").append(ClassesKechengPeer.ID).append("=").append(KaoqinPeer.CLASSES_KECHENG_ID);
		sbr.append(" where  ").append(KaoqinPeer.KAOQIN).append(" > 0");
		sbr.append(" and ").append(KaoqinPeer.STUDENT_ID).append("=").append(studentId);
		sbr.append(" and ").append(ClassesKechengPeer.CLASSES_ID).append("=").append(classesId);
		
		sbr.append(" and ").append(KaoqinPeer.DAY).append(">= '").append(startDay).append("' ");
		sbr.append(" and ").append(KaoqinPeer.DAY).append("<= '").append(endDay).append("' ");
		
		if(kechengId > 0){
			sbr.append(" and ").append(ClassesKechengPeer.KECHENG_ID).append("=").append(kechengId);
		}
		try {
			List<Record> searchList = ClassesKechengPeer.executeQuery(sbr.toString());
			if(searchList != null){
				return searchList.get(0).getValue(1).asInt() * 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 计算总课时
	 * 
	 * 1.计算两个日期间隔天数days
	 * 2.days/7 得到整的周数 weeks
	 * 3.开始日期＋（weeks*7）得到整周结束那天的日期，secondDay
	 * 4.secondDay循环到结束日期，并计算出每天是周几，加入到数组或set中，wks
	 * 5.查询sql计算每周课程数，乘以weeks,得到totalA;
	 * 6.根据wks查询数据库（in），查询课程在班级课时数totalB
	 * 7.返回结果：totalA + totalB
	 * 
	 * @param start 开始日期
	 * @param end 结束日期
	 * @param classesId 班级id
	 * @param kechengId 课程id
	 * @return
	 */
	public static int getTotalKeshi(Date start, Date end, int classesId, int kechengId){
		log.info("计算总课时；班级id：" + classesId);
		log.info("计算总课时；课程id：" + kechengId);
		log.info("计算总课时；学期时间范围：" + start + "--" + end);
		
		int weekKeshi = PaikeServiceImpl.countClassKeshi(classesId, kechengId, "");
		log.info("计算总课时；每周课程数：" + weekKeshi);
		if(weekKeshi == 0){
			return 0;
		}
		
		int days = SchoaUtil.selectDaysBetweenDate(start, end).intValue();
		log.info("计算总课时；学期总天数：" + days);
		
		int weeks = days/7;
		Date secondDay = SchoaUtil.addDate(start, weeks * 7 - 1); 
		log.info("计算总课时；整周结束那天的日期：" + secondDay);
		
		String weekIndexs = SchoaUtil.getWeekIndexBetweenDate(secondDay, end);
		log.info("计算总课时；剩余的天（周几）：" + weekIndexs);
		
		int secondKeshi = 0;
		if(StringUtils.isNotBlank(weekIndexs)){
			secondKeshi = PaikeServiceImpl.countClassKeshi(classesId, kechengId, "("+weekIndexs+")");
			log.info("计算总课时；剩余的课时：" + secondKeshi);
		}
		
		int total = weekKeshi * weeks + secondKeshi;
		log.info("计算总课时；总课时：" + total);
		return total * 2;
	}
	
	public static void main(String[] args) {
		System.out.println(22L/7);
	}
}
