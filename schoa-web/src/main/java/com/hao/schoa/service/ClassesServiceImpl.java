package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.Classes;
import com.hao.schoa.po.ClassesKechengPeer;
import com.hao.schoa.po.ClassesPeer;
import com.hao.schoa.po.ClassesStudentPeer;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.LibrarysPeer;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.po.XueqiPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class ClassesServiceImpl {

	public static Map<String, Object> search(int xueqi, int start, int limit) {
		int total = 0;
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		StringBuffer searchSql = new StringBuffer();
		
		searchSql.append(" select ").append(ClassesPeer.TABLE_NAME).append(".* ")
					.append(",").append(TeacherPeer.NAME)
					.append(",").append(XueqiPeer.NAME)
					.append(",").append(XueqiPeer.START_DATE)
					.append(",").append(XueqiPeer.END_DATE);
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(ClassesPeer.TABLE_NAME);
		sbr.append(" left join ").append(TeacherPeer.TABLE_NAME).append(" on ").append(TeacherPeer.ID).append("=").append(ClassesPeer.TEACHER_ID);
		sbr.append(" left join ").append(XueqiPeer.TABLE_NAME).append(" on ").append(XueqiPeer.ID).append("=").append(ClassesPeer.XUEQI_ID);
		
		sbr.append(" where 1=1 ");
		if(xueqi > 0){
			sbr.append(" and ").append(ClassesPeer.XUEQI_ID).append(" = ").append(xueqi);
		}
		
		countSql.append(sbr);
		searchSql.append(sbr);
		searchSql.append(" order by ").append(ClassesPeer.ID).append(" desc ");
		searchSql.append(" limit  ").append(start).append(",").append(limit);
		
		List<Classes> list = new ArrayList<Classes>();
		try {
			List<Record> countList = LibrarysPeer.executeQuery(countSql.toString());
			List<Record> searchList = ClassesPeer.executeQuery(searchSql.toString());
			total = countList.get(0).getValue("count").asInt();
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Classes obj = ClassesPeer.row2Object(row, 1, ClassesPeer.getOMClass());
				
				Teacher teacher = new Teacher();
				teacher.setId(obj.getTeacherId());
				teacher.setName(row.getValue(TeacherPeer.NAME).asString());
				obj.setTeacher(teacher);
				
				Xueqi xq = new Xueqi();
				xq.setName(row.getValue(XueqiPeer.NAME).asString());
				xq.setStartDate(row.getValue(XueqiPeer.START_DATE).asDate());
				xq.setEndDate(row.getValue(XueqiPeer.END_DATE).asDate());
				obj.setXueqi(xq);
			
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
	
	public static Classes getById(int id) {
		if(id > 0){
			try {
				Classes classes = ClassesPeer.retrieveByPK(id);
				if(classes != null && classes.getTeacherId() > 0){
					Teacher teacher = TeacherServiceImpl.getById(classes.getTeacherId());
					classes.setTeacher(teacher);
				}
				
				if(classes != null && classes.getXueqiId() > 0){
					Xueqi xueqi = XueqiServiceImpl.getById(classes.getXueqiId());
					classes.setXueqi(xueqi);
				}
				return classes;
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
	
	public static Classes retrieveByPK(int id) {
		if(id > 0){
			try {
				return ClassesPeer.retrieveByPK(id);
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
	
	public static List<Classes> getClassesList(){
		return getClassesList(0);
	} 
	
	/**
	 * 查询学期下的班级
	 */
	public static List<Classes> getClassesList(int xueqi){
		Criteria c = new Criteria();
		if(xueqi > 0){
			c.add(ClassesPeer.XUEQI_ID, xueqi);
		}
		try {
			return ClassesPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询学期下的班级ID
	 */
	public static Set<Integer> getClassesIds(int xueqi){
		List<Classes> ls = getClassesList(xueqi);
		if(ls == null){
			return null;
		}
		Set<Integer> ids = new HashSet<Integer>();
		for(Classes c : ls){
			ids.add(c.getId());
		}
		return ids;
	}

	/**
	 * 查学生所在班级
	 * @param studentId
	 * @return
	 */
	public static List<Classes> getClassesByStudent(int studentId) {
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(ClassesPeer.TABLE_NAME).append(".* ")
			.append(" , ").append(ClassesStudentPeer.YOUXIU);
		
		sbr.append(" from ").append(ClassesStudentPeer.TABLE_NAME);
		sbr.append(" left join ").append(ClassesPeer.TABLE_NAME)
				.append(" on ").append(ClassesPeer.ID).append("=").append(ClassesStudentPeer.CLASSES_ID);
		sbr.append(" where ").append(ClassesStudentPeer.STUDENT_ID).append(" = ").append(studentId);
		sbr.append(" group by ").append(ClassesStudentPeer.CLASSES_ID);
		
		List<Classes> list = new ArrayList<Classes>();
		try {
			List<Record> searchList = ClassesPeer.executeQuery(sbr.toString());
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Classes obj = ClassesPeer.row2Object(row, 1, ClassesPeer.getOMClass());
				obj.setYouxiu(row.getValue(ClassesStudentPeer.YOUXIU).asInt());
				Xueqi xueqi = XueqiServiceImpl.getById2(obj.getXueqiId());
				obj.setXueqi(xueqi);
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	} 
	
	/**
	 * 查询班级下所有教师
	 * @param classId
	 * @return
	 */
	public static List<Teacher> getClassTeachers(int xueqiId, int classId){
		List<Teacher> teachers = null;
		StringBuffer sbr = new StringBuffer();
		sbr.append(" select ").append(TeacherPeer.TABLE_NAME).append(".* ")
			.append(",").append(KechengPeer.ID)
			.append(",").append(KechengPeer.XUEQI_ID)
			.append(",").append(KechengPeer.NAME)
			.append(",").append(ClassesKechengPeer.CLASSES_ID)
			.append(" from ").append(ClassesKechengPeer.TABLE_NAME)
			.append(" left join ").append(KechengPeer.TABLE_NAME)
			.append(" on ").append(KechengPeer.ID).append(" = ").append(ClassesKechengPeer.KECHENG_ID)
			.append(" left join ").append(TeacherPeer.TABLE_NAME)
			.append(" on ").append(TeacherPeer.ID).append(" = ").append(KechengPeer.TEACHER_ID);
		
		sbr.append(" where ").append(" 1 = 1 ");
		
		if(xueqiId > 0){
			sbr.append(" and ").append(KechengPeer.XUEQI_ID).append("=").append(xueqiId);
		}
		if(classId > 0){
			sbr.append(" and ").append(ClassesKechengPeer.CLASSES_ID).append("=").append(classId);
		}
		sbr.append(" group by ").append(ClassesKechengPeer.CLASSES_ID).append(",").append(ClassesKechengPeer.KECHENG_ID);
		sbr.append(" order by ").append(ClassesKechengPeer.CLASSES_ID).append(",").append(TeacherPeer.ID);
		try {
			List<Record> ls = BasePeer.executeQuery(sbr.toString());
			if(ls != null && !ls.isEmpty()){
				teachers = new ArrayList<Teacher>();
				for (int i = 0; i < ls.size(); i++) {
					Record row = ls.get(i);
					Teacher teacher = TeacherPeer.row2Object(row, 1, TeacherPeer.getOMClass());
					
					Kecheng kecheng = new Kecheng();
					kecheng.setId(row.getValue(KechengPeer.ID).asInt());
					kecheng.setName(row.getValue(KechengPeer.NAME).asString());
					kecheng.setXueqiId(row.getValue(KechengPeer.XUEQI_ID).asInt());
					
					teacher.setClassesId(row.getValue(ClassesKechengPeer.CLASSES_ID).asInt());
					
					teacher.setKecheng(kecheng);
					teachers.add(teacher);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}

	public static List<Classes> getTeacherClassesList(int xueqiId,int teacherId) {
		//1.根据教师id找到教师所有课程
//		select * from kecheng where teacher_id = 1
		List<Kecheng> kechengList = getTeacherKechengList(xueqiId,teacherId);
		if(kechengList == null || kechengList.isEmpty()){
			return null;
		}
		String ids = "";
		for(int i=0;i<kechengList.size();i++){
			Kecheng kc = kechengList.get(i);
			if(i!=0){
				ids += ",";
			}
			ids += kc.getId();
		}
		
		//2.根据课程找班级
		StringBuffer sql =  new StringBuffer();
		sql.append(" select ").append(ClassesPeer.TABLE_NAME).append(".* ")
			.append(" from ").append(ClassesKechengPeer.TABLE_NAME)
			.append(" left join ").append(ClassesPeer.TABLE_NAME).append(" on ").append(ClassesPeer.ID).append("=").append(ClassesKechengPeer.CLASSES_ID)
			.append(" where ").append(ClassesKechengPeer.KECHENG_ID).append(" in (").append(ids).append(" ) ")
			.append(" group by ").append(ClassesKechengPeer.CLASSES_ID);
		
		List<Classes> cls = new ArrayList<Classes>();
		try {
			List<Record> ls = BasePeer.executeQuery(sql.toString());
			if(ls != null && !ls.isEmpty()){
				for (int j = 0; j < ls.size(); j++) {
					Record row = ls.get(j);
					Classes c = ClassesPeer.row2Object(row, 1, ClassesPeer.getOMClass());
					cls.add(c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cls;
	}

	public static List<Kecheng> getTeacherKechengList(int xueqiId, int teacherId) {
		Criteria c = new Criteria();
		c.add(KechengPeer.XUEQI_ID, xueqiId);
		c.add(KechengPeer.TEACHER_ID, teacherId);
		try {
			return KechengPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到学期下所有班级
	 * @param xueqiId
	 * @return
	 */
	public static List<Classes> getListByXueqi(int xueqiId){
		Criteria c = new Criteria();
		c.add(ClassesPeer.XUEQI_ID, xueqiId);
		try {
			return ClassesPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
