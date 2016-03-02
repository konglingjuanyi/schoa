package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.Classes;
import com.hao.schoa.po.ClassesStudent;
import com.hao.schoa.po.ClassesStudentPeer;
import com.hao.schoa.po.Country;
import com.hao.schoa.po.CountryPeer;
import com.hao.schoa.po.Score;
import com.hao.schoa.po.Student;
import com.hao.schoa.po.StudentPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class StudentServiceImpl {

	public static Map<String, Object> searchStudents(String huzhao,String name,int start,int limit) {
		int total = 0;
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		StringBuffer searchSql = new StringBuffer();
		
		searchSql.append(" select ").append(StudentPeer.TABLE_NAME).append(".* ")
					.append(",").append(CountryPeer.CNAME)
					.append(",").append(CountryPeer.ENAME)
					.append(",").append(CountryPeer.PATH)
					.append(",").append(CountryPeer.STATES);
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(StudentPeer.TABLE_NAME);
		sbr.append(" left join ").append(CountryPeer.TABLE_NAME).append(" on ").append(CountryPeer.ID).append("=").append(StudentPeer.NATION);
		
		sbr.append(" where 1=1 ");
		if(StringUtils.isNotBlank(name)){
			sbr.append(" and ( ").append(StudentPeer.CNAME).append(" like '%").append(name).append("%' ");
			sbr.append(" or ").append(StudentPeer.ENAME).append(" like '%").append(name).append("%' )");
		}
		if(StringUtils.isNotBlank(huzhao)){
			sbr.append(" and ").append(StudentPeer.PASS_NUMB).append(" = '").append(huzhao).append("' ");
		}
		
		countSql.append(sbr);
		searchSql.append(sbr)
				.append(" order by ").append(StudentPeer.STATE).append(" asc ")
				.append(" , ").append(StudentPeer.CODE).append(" desc ")
				.append(" limit  ").append(start).append(",").append(limit);
		
		List<Student> list = new ArrayList<Student>();
		try {
			List<Record> countList = StudentPeer.executeQuery(countSql.toString());
			List<Record> searchList = StudentPeer.executeQuery(searchSql.toString());
			total = countList.get(0).getValue("count").asInt();
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Student obj = StudentPeer.row2Object(row, 1, StudentPeer.getOMClass());
				
				Country cty = new Country();
				cty.setId(obj.getNation());
				cty.setEname(row.getValue(CountryPeer.ENAME).asString());
				cty.setCname(row.getValue(CountryPeer.CNAME).asString());
				cty.setPath(row.getValue(CountryPeer.PATH).asString());
				cty.setStates(row.getValue(CountryPeer.STATES).asString());
				obj.setCountry(cty);
			
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
	
	public static Map<String, Object> searchStudentsByXueqi(int xueqiId, int start, int limit) {
		List<Student> list = new ArrayList<Student>();
		int total = 0;
		Set<Integer> ids = ClassesServiceImpl.getClassesIds(xueqiId);
		if(ids != null && ids.size() > 0){
			StringBuffer sb = new StringBuffer();
			int i=0;
			for(int id : ids){
				if(i!=0){
					sb.append(",");
				}
				sb.append(id);
				i++;
			}
			list = searchStudentByClassIds(sb.toString(),start,limit);
			total = countStudentByClassIds(sb.toString());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, total);
		map.put(Constant.DATA, list);
		return map;
	}

	
	public static int countStudentByClassIds(String ids) {
		StringBuffer sbr = new StringBuffer(" select count(*) as count ");
		sbr.append(getStudentByClassIdStrs(ids));
		try {
			List<Record> countList = StudentPeer.executeQuery(sbr.toString());
			return countList.get(0).getValue("count").asInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static StringBuffer getStudentByClassIdStrs(String ids){
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(ClassesStudentPeer.TABLE_NAME);
		sbr.append(" left join ").append(StudentPeer.TABLE_NAME).append(" on ").append(StudentPeer.ID).append("=").append(ClassesStudentPeer.STUDENT_ID);
		sbr.append(" left join ").append(CountryPeer.TABLE_NAME).append(" on ").append(CountryPeer.ID).append("=").append(StudentPeer.NATION);
		sbr.append(" where ").append(ClassesStudentPeer.CLASSES_ID).append(" in (").append(ids).append(")");
		return sbr;
	}
	
	public static List<Student> searchStudentByClassIds(String ids,int start,int limit) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(StudentPeer.TABLE_NAME).append(".* ")
					.append(",").append(CountryPeer.CNAME)
					.append(",").append(CountryPeer.ENAME)
					.append(",").append(CountryPeer.PATH)
					.append(",").append(CountryPeer.STATES);
		
		sbr.append(getStudentByClassIdStrs(ids));
		sbr.append(" order by ").append(StudentPeer.STATE).append(" asc,").append(StudentPeer.CODE).append(" desc");
		sbr.append(" limit  ").append(start).append(",").append(limit);
		
		List<Student> list = new ArrayList<Student>();
		try {
			List<Record> searchList = StudentPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Student obj = StudentPeer.row2Object(row, 1, StudentPeer.getOMClass());
				
				Country cty = new Country();
				cty.setId(obj.getNation());
				cty.setEname(row.getValue(CountryPeer.ENAME).asString());
				cty.setCname(row.getValue(CountryPeer.CNAME).asString());
				cty.setPath(row.getValue(CountryPeer.PATH).asString());
				cty.setStates(row.getValue(CountryPeer.STATES).asString());
				obj.setCountry(cty);
			
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Student getById(int id) {
		if(id > 0){
			try {
				Student stu = StudentPeer.retrieveByPK(id);
				if(stu.getNation() > 0){
					Country country = CountryPeer.retrieveByPK(stu.getNation());
					stu.setCountry(country);
				}
				return stu;
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
	
	/**
	 * 
	 * @param ids
	 * @param name
	 * @return
	 */
	public static List<Student> searchStudentList(String ids,String name,String huzhao) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(StudentPeer.TABLE_NAME).append(".* ")
					.append(",").append(CountryPeer.CNAME)
					.append(",").append(CountryPeer.ENAME)
					.append(",").append(CountryPeer.PATH)
					.append(",").append(CountryPeer.STATES);
		
		sbr.append(" from ").append(StudentPeer.TABLE_NAME);
		sbr.append(" left join ").append(CountryPeer.TABLE_NAME).append(" on ").append(CountryPeer.ID).append("=").append(StudentPeer.NATION);
		
		sbr.append(" where 1=1 ");
		if(StringUtils.isNotBlank(ids)){
			sbr.append(" and ").append(StudentPeer.ID).append(" in (").append(ids).append(") ");
		}
		if(StringUtils.isNotBlank(name)){
			sbr.append(" and ( ").append(StudentPeer.CNAME).append(" like '%").append(name).append("%' ");
			sbr.append(" or ").append(StudentPeer.ENAME).append(" like '%").append(name).append("%' )");
		}
		if(StringUtils.isNotBlank(huzhao)){
			sbr.append(" and ").append(StudentPeer.PASS_NUMB).append("= '").append(huzhao).append("' ");
		}
		sbr.append(" order by ").append(StudentPeer.CODE).append(" desc");
		
		List<Student> list = new ArrayList<Student>();
		try {
			List<Record> searchList = StudentPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Student obj = StudentPeer.row2Object(row, 1, StudentPeer.getOMClass());
				
				Country cty = new Country();
				cty.setId(obj.getNation());
				cty.setEname(row.getValue(CountryPeer.ENAME).asString());
				cty.setCname(row.getValue(CountryPeer.CNAME).asString());
				cty.setPath(row.getValue(CountryPeer.PATH).asString());
				cty.setStates(row.getValue(CountryPeer.STATES).asString());
				obj.setCountry(cty);
			
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Map<String, Object> searchClassesStudentMap(int classesId) {
		List<Student> list = searchClassesStudent(classesId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, list.size());
		map.put(Constant.DATA, list);
		return map;
	}
	
	public static List<Student> searchClassesStudent(int classesId) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(StudentPeer.TABLE_NAME).append(".* ")
					.append(",").append(CountryPeer.CNAME)
					.append(",").append(CountryPeer.ENAME)
					.append(",").append(CountryPeer.PATH)
					.append(",").append(CountryPeer.STATES)
					.append(",").append(ClassesStudentPeer.YOUXIU)
					.append(",").append(ClassesStudentPeer.JINBU);
		
		sbr.append(" from ").append(ClassesStudentPeer.TABLE_NAME);
		sbr.append(" left join ").append(StudentPeer.TABLE_NAME).append(" on ").append(StudentPeer.ID).append("=").append(ClassesStudentPeer.STUDENT_ID);
		sbr.append(" left join ").append(CountryPeer.TABLE_NAME).append(" on ").append(CountryPeer.ID).append("=").append(StudentPeer.NATION);
		
		sbr.append(" where 1=1 ");
		if(classesId > 0){
			sbr.append(" and ").append(ClassesStudentPeer.CLASSES_ID).append("=").append(classesId);
		}
		sbr.append(" order by ").append(StudentPeer.CODE).append(" desc");
		
		List<Student> list = new ArrayList<Student>();
		try {
			List<Record> searchList = ClassesStudentPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Student obj = StudentPeer.row2Object(row, 1, StudentPeer.getOMClass());
				//优秀生设置
				obj.setYouxiu(row.getValue(ClassesStudentPeer.YOUXIU).asInt());
				obj.setJinbu(row.getValue(ClassesStudentPeer.JINBU).asInt());
				
				Country cty = new Country();
				cty.setId(obj.getNation());
				cty.setEname(row.getValue(CountryPeer.ENAME).asString());
				cty.setCname(row.getValue(CountryPeer.CNAME).asString());
				cty.setPath(row.getValue(CountryPeer.PATH).asString());
				cty.setStates(row.getValue(CountryPeer.STATES).asString());
				obj.setCountry(cty);
			
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Student> searchClassesStudent(int classesId, int kechengId) {
		Map<Integer,Score> scoreMap = ScoreServiceImpl.getStudentScoreMap(classesId, kechengId);
		List<Student> ls = searchClassesStudent(classesId);
		if(ls == null || scoreMap == null || scoreMap.size() == 0){
			return ls;
		}
		for(Student stu : ls){
			if(scoreMap.containsKey(stu.getId())){
				stu.setScore(scoreMap.get(stu.getId()));
			}
		}
		java.util.Collections.sort(ls, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				Score sc1 = s1.getScore();
				Score sc2 = s2.getScore();
				double v1 = sc1 == null?0:sc1.getScJuanmian();
				double v2 = sc2 == null?0:sc2.getScJuanmian();
				return v1 - v2 > 0 ? -1 : 1;
			}
		});

		return ls;
	}

	/**
	 * 学生移出班级
	 * @param classesId
	 * @param studentId
	 * @return
	 */
	public static boolean stuMoveoutClass(int classesId,
			int studentId) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" delete from ").append(ClassesStudentPeer.TABLE_NAME)
			.append(" where ").append(ClassesStudentPeer.CLASSES_ID).append("=").append(classesId)
			.append(" and ").append(ClassesStudentPeer.STUDENT_ID).append("=").append(studentId);
		
		try {
			BasePeer.executeStatement(sbr.toString());
			return true;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	/**
	 * 设置优秀生状态
	 * @param classesId
	 * @param studentId
	 * @param youxiu
	 * @return
	 */
	public static boolean studentYouxiu(int classesId,int studentId, int youxiu) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" UPDATE ").append(ClassesStudentPeer.TABLE_NAME)
			.append(" set ").append(ClassesStudentPeer.YOUXIU).append("=").append(youxiu)
			.append(" where ").append(ClassesStudentPeer.STUDENT_ID).append("=").append(studentId)
			.append(" and ").append(ClassesStudentPeer.CLASSES_ID).append("=").append(classesId);
		try {
			BasePeer.executeStatement(sbr.toString());
			return true;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	public static boolean studentJinbu(int classesId,int studentId, int jinbu) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" UPDATE ").append(ClassesStudentPeer.TABLE_NAME)
		.append(" set ").append(ClassesStudentPeer.JINBU).append("=").append(jinbu)
		.append(" where ").append(ClassesStudentPeer.STUDENT_ID).append("=").append(studentId)
		.append(" and ").append(ClassesStudentPeer.CLASSES_ID).append("=").append(classesId);
		try {
			BasePeer.executeStatement(sbr.toString());
			return true;
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * 查询班级所在学期下没有排课的学生
	 * @param classesId
	 * @param name
	 * @param huzhao
	 * @return
	 */
	public static List<Student> searchOtherStu(int classesId,String name,String huzhao) {
		List<Student> all = searchStudentList("",name,huzhao);
		Set<Integer> ids = getXueqiPaikeStudentIds(classesId);
		List<Student> resultList = new ArrayList<Student>();
		for(Student stu : all){
			if(!ids.contains(stu.getId()) && stu.getState() != 2){
				resultList.add(stu);
			}
		}
		return resultList;
	}
	
	/**
	 * 查询班级所在学期下没有排课的学生
	 * @param classesId
	 * @param name
	 * @param huzhao
	 * @return
	 */
	public static Map<String, Object> searchOtherStuMap(int classesId,String name,String huzhao) {
		List<Student> ls = searchOtherStu(classesId,name,huzhao);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, ls.size());
		map.put(Constant.DATA, ls);
		return map;
	}
	
	
	/**
	 * 查询班级所在学期下没有排课的学生
	 * @param classesId
	 * @return
	 */
	public static Set<Integer> getXueqiPaikeStudentIds(int classesId){
		List<ClassesStudent> ls = getXueqiPaikeStudents(classesId);
		Set<Integer> ids = new HashSet<Integer>();
		if(ls != null && ls.size() > 0){
			for(ClassesStudent obj : ls){
				ids.add(obj.getStudentId());
			}
		}
		return ids;
	}
	
	/**
	 * 查询班级下学生
	 * @param classesId
	 * @return
	 */
	public static List<ClassesStudent> getXueqiPaikeStudents(int classesId){
		Classes banji = ClassesServiceImpl.retrieveByPK(classesId);
		Criteria criteria = new Criteria();
		try {
			criteria.add(ClassesStudentPeer.XUEQI_ID, banji.getXueqiId());
			return ClassesStudentPeer.doSelect(criteria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 班级添加学生
	 * @param classesId
	 * @param studentIds
	 * @param xueqiId
	 * @return
	 */
	public static boolean stuAddToClass(int classesId, String studentIds, int xueqiId) {
		if(StringUtils.isBlank(studentIds)){
			return false;
		}
		try {
			String ids[] = studentIds.split(",");
			for(String tmp : ids){
				int stuId = NumberUtils.toInt(tmp);
				if(stuId > 0){
					ClassesStudent cs = new ClassesStudent();
					cs.setClassesId(classesId);
					cs.setStudentId(stuId);
					cs.setXueqiId(xueqiId);
					ClassesStudentPeer.doInsert(cs);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 学生所在班级及各科成绩
	 * @param studentId
	 * @return
	 */
	public static Map<Classes, List<Score>> getClassesScoreMap(int studentId) {
		//1.查学生所在班级
		List<Classes> classesList = ClassesServiceImpl.getClassesByStudent(studentId);
		if(classesList == null || classesList.size() < 1){
			return null;
		}
		//2.查班级成绩
		Map<Classes, List<Score>> map = new LinkedHashMap<Classes, List<Score>>();
		for(Classes classes : classesList){
			if(classes.getTeacherId() > 0){
				classes.setTeacher(TeacherServiceImpl.getById(classes.getTeacherId()));
			}
			map.put(classes, ScoreServiceImpl.getStudentScore(classes.getId(), studentId));
		}
		return map;
	}

	/**
	 * 根据护照号查找学生
	 */
	public static List<Student> getStudentByPassNumb(String passNumb) {
		Criteria c = new Criteria();
		c.add(StudentPeer.PASS_NUMB, passNumb);
		try {
			return StudentPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置学生离校，返校
	 * @param sysUser
	 * @param studentId
	 * @param oldState
	 * @param newState
	 * @param leaveDate
	 * @param leaveReason
	 * @return
	 */
	public static boolean updateStudentState(String sysUser,int studentId, int oldState, int newState, String leaveDate, String leaveReason) {
		StringBuffer sbr = new StringBuffer();
		sbr.append("update ").append(StudentPeer.TABLE_NAME)
			.append(" set ").append(StudentPeer.STATE).append("=").append(newState)
			.append(" , ").append(StudentPeer.STATE_UPTIME).append("='").append(leaveDate).append("'")
			.append(" , ").append(StudentPeer.STATE_INTRO).append("='").append(leaveReason).append("'")
			.append(" where ").append(StudentPeer.STATE).append("=").append(oldState)
			.append(" and ").append(StudentPeer.ID).append("=").append(studentId);
		
		try {
			if(StudentPeer.executeStatement(sbr.toString()) > 0){
				StudentStateLogServiceImple.saveStudentStateLog(sysUser,studentId,newState,leaveDate,leaveReason);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Student retrieveByPK(int studentId) {
		try {
			return StudentPeer.retrieveByPK(studentId);
		} catch (NoRowsException e) {
			e.printStackTrace();
		} catch (TooManyRowsException e) {
			e.printStackTrace();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

}
