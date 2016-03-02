package com.hao.schoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.hao.schoa.po.Member;
import com.hao.schoa.po.MemberPeer;
import com.hao.schoa.po.Role;
import com.hao.schoa.po.RolePeer;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.tools.Constant;
import com.workingdogs.village.Record;

public class MemberServiceImpl {

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Member getMemberByName(String name){
		if(StringUtils.isBlank(name)){
			return null;
		}
		Criteria criteria = new Criteria();
		criteria.add(MemberPeer.NAME, name);
		try {
			List<Member> ls = MemberPeer.doSelect(criteria);
			if(ls.size() > 0){
				return ls.get(0);
			}
		} catch (TorqueException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<String, Object> search(int start, int limit) {
		int total = 0;
		StringBuffer countSql = new StringBuffer(" select count(*) as count");
		StringBuffer searchSql = new StringBuffer();
		
		searchSql.append(" select ").append(MemberPeer.TABLE_NAME).append(".* ")
				.append(",").append(TeacherPeer.ID)
				.append(",").append(TeacherPeer.NAME)
				.append(",").append(RolePeer.NAME)
				.append(",").append(RolePeer.INTRO);
		
		StringBuffer sbr = new StringBuffer();
		sbr.append(" from ").append(MemberPeer.TABLE_NAME);
		sbr.append(" left join ").append(RolePeer.TABLE_NAME).append(" on ").append(RolePeer.ID).append("=").append(MemberPeer.ROLE_ID);
		sbr.append(" left join ").append(TeacherPeer.TABLE_NAME).append(" on ").append(TeacherPeer.ID).append("=").append(MemberPeer.TEACHER_ID);
		
		countSql.append(sbr);
		searchSql.append(sbr)
				.append(" order by ").append(MemberPeer.VALID)
				.append(" limit  ").append(start).append(",").append(limit);
		
		List<Member> list = new ArrayList<Member>();
		try {
			List<Record> countList = MemberPeer.executeQuery(countSql.toString());
			List<Record> searchList = MemberPeer.executeQuery(searchSql.toString());
			total = countList.get(0).getValue("count").asInt();
			for (int i = 0; i < searchList.size(); i++) {
				Record row = searchList.get(i);
				Member obj = MemberPeer.row2Object(row, 1, MemberPeer.getOMClass());
				
				Role role = new Role();
				role.setId(obj.getRoleId());
				role.setName(row.getValue(RolePeer.NAME).asString());
				role.setIntro(row.getValue(RolePeer.INTRO).asString());
				obj.setRole(role);
				
				Teacher teacher = new Teacher();
				teacher.setId(row.getValue(TeacherPeer.ID).asInt());
				teacher.setName(row.getValue(TeacherPeer.NAME).asString());
				obj.setTeacher(teacher);
			
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
	
	public static Member getById(int id){
		if(id > 0){
			try {
				return MemberPeer.retrieveByPK(id);
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
}
