package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.hao.schoa.container.ContainerTeacherKecheng;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class TeacherServiceImpl {
	
	/**
	 * 
	 * @param teacherId -1表不考虑教师id查询，否则根据教师id查询
	 * @param name
	 * @param type
	 * @param start
	 * @param limit
	 * @return
	 */
	public static Map<String, Object> searchTeachers(int teacherId,String name,int type,int start,int limit) {
		int total = 0;
		List<Teacher> list = null;
		
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		StringBuffer searchSql = new StringBuffer();
		
		searchSql.append(" select ").append(TeacherPeer.TABLE_NAME).append(".* ");
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(TeacherPeer.TABLE_NAME);
		
		sbr.append(" where 1=1 ");
		if(StringUtils.isNotBlank(name)){
			sbr.append(" and ").append(TeacherPeer.NAME).append(" like '%").append(name).append("%' ");
		}
		if(type >= 0){
			sbr.append(" and ").append(TeacherPeer.TYPE).append(" = ").append(type);
		}
		if(teacherId != -1){
			sbr.append(" and ").append(TeacherPeer.ID).append(" = ").append(teacherId);
		}
		
		
		countSql.append(sbr);
		searchSql.append(sbr);
		
		searchSql.append(" order by ").append(TeacherPeer.STATE).append(" asc ");
		searchSql.append(" , ").append(TeacherPeer.CODE).append(" desc ");
			
		searchSql.append(" limit  ").append(start).append(",").append(limit);
		
		list = new ArrayList<Teacher>();
		try {
			List<Record> countList = TeacherPeer.executeQuery(countSql.toString());
			List<Record> teacherList = TeacherPeer.executeQuery(searchSql.toString());
			total = countList.get(0).getValue("count").asInt();
			for (int i = 0; i < teacherList.size(); i++) {
				Record row = teacherList.get(i);
				Teacher obj = TeacherPeer.row2Object(row, 1, TeacherPeer.getOMClass());
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

	public static Map<String, Object> searchTeachers(String name,int type) {
		Criteria criteria = new Criteria();
		int total = 0;
		List<Teacher> list = null;
		if(StringUtils.isNotBlank(name)){
			criteria.add(TeacherPeer.NAME, (Object)("%"+name+"%"), criteria.LIKE); 
		}
		if(type == 0){
			criteria.add(TeacherPeer.TYPE, 0);
		}
		if(type == 1){
			criteria.add(TeacherPeer.TYPE,1);
		}
		criteria.addDescendingOrderByColumn(TeacherPeer.CODE);
		try {
			list = TeacherPeer.doSelect(criteria);
			total = list.size();
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.TOTAL, total);
		map.put(Constant.DATA, list);
		return map;
	}
	
	public static List<Teacher> searchTeachersAsList(){
		Map<String, Object> map = TeacherServiceImpl.searchTeachers("", -1);
		List<Teacher> teachers = new ArrayList<Teacher>();
		if(map != null){
			teachers = (List<Teacher>) map.get(Constant.DATA);
		}
		return teachers;
	}

	public static Teacher getById(int id) {
		if(id > 0){
			try {
				return TeacherPeer.retrieveByPK(id);
			} catch (NoRowsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TooManyRowsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param xueqiId
	 * @param banjiId
	 * @param waipinOrZaibian  0正编，1外聘
	 * @return
	 */
	public static List<Teacher> searchTeacherList(int xueqiId, int banjiId, int waipinOrZaibian) {
		List<Teacher> ls = new ArrayList<Teacher>();
		//得到班级下所有教师
		List<Teacher> teacherList = ClassesServiceImpl.getClassTeachers(xueqiId,banjiId);
		//只要外聘教师
		if(teacherList != null && !teacherList.isEmpty()){
			for(Teacher teacher : teacherList){
				if(teacher.getType() == waipinOrZaibian){
					ls.add(teacher);
				}
			}
		}
		return ls;
	}
	
	/**
	 * 
	 * @param waipinOrZaibian 0正编，1外聘
	 * @param teacherId
	 * @return
	 */
	public static List<Teacher> searchTeacherList(int waipinOrZaibian,int teacherId) {
		Criteria c = new Criteria();
		c.add(TeacherPeer.TYPE, waipinOrZaibian);
		if(teacherId > 0){
			c.add(TeacherPeer.ID, teacherId);
		}
		try {
			return TeacherPeer.doSelect(c);
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询教师在所有学期，所有班级，担任的课程
	 * @param teacherId
	 * @return
	 */
	public static List<ContainerTeacherKecheng> seacherTeacherKechengList(int teacherId){
		List<ContainerTeacherKecheng> ls = new ArrayList<ContainerTeacherKecheng>();
		String sql = "select k.xueqi_id,ck.classes_id,k.id,k.name"
				+ " from classes_kecheng ck"
				+ " left join kecheng k on k.id = ck.kecheng_id"
				+ " where k.teacher_id = " + teacherId
				+ " group by k.xueqi_id,ck.classes_id,k.id"
				+ " order by k.xueqi_id desc,ck.classes_id desc ";
		
		try {
			List<Record> list = BasePeer.executeQuery(sql);
			if(list != null && !list.isEmpty()){
				for(Record rec : list){
					ContainerTeacherKecheng tk = new ContainerTeacherKecheng();
					tk.setXueqiId(rec.getValue(1).asInt());
					tk.setBanjiId(rec.getValue(2).asInt());
					tk.setKechengId(rec.getValue(3).asInt());
					tk.setTeacherId(teacherId);
					tk.setKechengName(rec.getValue(4).asString());
					ls.add(tk);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ls;
	}
	
	/**
	 * 根据身份证号查教师
	 * @param cardNumb
	 * @return
	 */
	public static Teacher getTeacherByCardNumb(String cardNumb){
		Criteria c = new Criteria();
		c.add(TeacherPeer.CARD_NUMB, cardNumb);
		try {
			List<Teacher> ls = TeacherPeer.doSelect(c);
			if(!ls.isEmpty()){
				return ls.get(0);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}

}
