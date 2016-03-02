package com.hao.schoa.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.TeacherPeer;
import com.hao.schoa.po.TeacherStateLog;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.TeacherServiceImpl;
import com.hao.schoa.service.TeacherStateLogServiceImpl;
import com.hao.schoa.tools.Constant;

@Controller
public class TeacherController extends BaseSchoa{

	@RequestMapping("/initTeacher.do")
	public String initTeacher(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "manager/teacher";
	}
	@RequestMapping("/initEditTeacher.do")
	public String initEditTeacher(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		
		if(id > 0){
			if(!isTeacherPrivilege(request, id)){
				return NOPRIVILEGES;
			}
		}else{
			if(!isAdminPrivilege(request)){
				return NOPRIVILEGES;
			}
		}
		
		
		Teacher teacher = TeacherServiceImpl.getById(id);
		request.setAttribute("teacher", teacher);
		return "manager/teacherEdit";
	}

	@RequestMapping("/searchTeachers.do")
	public void searchTeachers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		int type = NumberUtils.toInt(request.getParameter("type"),-1);
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		
		Map<String, Object> map = null;
		
		int teacherId = 0;
		Member member = getSysMember(request);
		if(member != null){
			if(isAdminRole(member.getRoleId()) ){//管理员，查询所有
				teacherId = -1;
			}else{//非管理员，只能查询到自己的记录
				teacherId = member.getTeacherId();
			}
		}
		map = TeacherServiceImpl.searchTeachers(teacherId,name, type,start,limit);
		
		response.getWriter().write(new Gson().toJson(map));
	}

	@RequestMapping("/saveTeacher.do")
	public String saveTeacher(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String type = request.getParameter("type");
		String birthday = request.getParameter("birthday");
		String married = request.getParameter("married");
		String hometown = request.getParameter("hometown");
		String graduated = request.getParameter("graduated");
		String pro = request.getParameter("pro");
		String address = request.getParameter("address");
		String experience = request.getParameter("experience");
		String research = request.getParameter("research");
		String code = request.getParameter("code");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String readingSchool = request.getParameter("readingSchool");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String cardNumb = request.getParameter("cardNumb");
		String headPic = request.getParameter("hideHeadPic");
		
		if(StringUtils.isBlank(cardNumb)){
			setErrorAttribute(request, "必须填写身份证号！");
			return FAIL;
		}
		Teacher t = TeacherServiceImpl.getTeacherByCardNumb(cardNumb);
		
		Teacher teacher = null;
		try {
			Date sdt = null;
			if(StringUtils.isNotBlank(startDate)){
				sdt = Constant.DATE.parse(startDate);
			}
			Date edt = null;
			if(StringUtils.isNotBlank(endDate)){
				edt = Constant.DATE.parse(endDate);
			}
			
			if(id == 0){
				if(!isAdminPrivilege(request)){
					return NOPRIVILEGES;
				}
				
				if(t != null){
					setErrorAttribute(request, "该（身份证号）用户已经存在！");
					return FAIL;
				}
				
				teacher = new Teacher();
				teacher.setCode(NumberUtils.toInt(code));
				teacher.setEntryTime(sdt);
				teacher.setLizhiTime(edt);
				teacher.setReadingSchool(readingSchool);
				teacher.setPhone(phone);
				teacher.setEmail(email);
				
				teacher.setName(name);
				teacher.setSex(NumberUtils.toInt(sex));
				teacher.setType(NumberUtils.toInt(type));
				teacher.setBirthday(birthday);
				teacher.setMarried(NumberUtils.toInt(married));
				teacher.setHometown(hometown);
				teacher.setGraduated(graduated);
				teacher.setPro(pro);
				teacher.setAddress(address);
				teacher.setExperience(experience);
				teacher.setResearch(research);
				teacher.setCardNumb(cardNumb);
				teacher.setHeadPic(headPic);
				
				TeacherPeer.doInsert(teacher);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"添加教师："+teacher.toString());
			}else{
				if(!isTeacherPrivilege(request,id)){
					return NOPRIVILEGES;
				}
				
				if(t != null && t.getId() != id){
					setErrorAttribute(request, "该（身份证号）用户已经存在！");
					return FAIL;
				}
				
				teacher = TeacherServiceImpl.getById(id);
				teacher.setCode(NumberUtils.toInt(code));
				teacher.setEntryTime(sdt);
				teacher.setLizhiTime(edt);
				teacher.setReadingSchool(readingSchool);
				teacher.setPhone(phone);
				teacher.setEmail(email);
				
				teacher.setName(name);
				teacher.setSex(NumberUtils.toInt(sex));
				teacher.setType(NumberUtils.toInt(type)); //修改时不能修改教师编制
				teacher.setBirthday(birthday);
				teacher.setMarried(NumberUtils.toInt(married));
				teacher.setHometown(hometown);
				teacher.setGraduated(graduated);
				teacher.setPro(pro);
				teacher.setAddress(address);
				teacher.setExperience(experience);
				teacher.setResearch(research);
				teacher.setCardNumb(cardNumb);
				teacher.setHeadPic(headPic);
				
				TeacherPeer.doUpdate(teacher);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改教师："+teacher.toString());
			}
			return setSuccessAttribute(request, "教师管理", "initTeacher.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	@RequestMapping("/delTeacher.do")
	public void delTeacher(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put(Constant.SUCCESS, false);
		try {
			TeacherPeer.executeStatement("delete from "+TeacherPeer.TABLE_NAME +" where id="+id);
			SchoaLogsServiceImpl.insertLogs(getSysUser(request),"删除教师，id："+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(Constant.SUCCESS, true);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	//教师离校记录
	@RequestMapping("/showTeacherStateLogs.do")
	public void showTeacherStateLogs(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		if(teacherId > 0){
			List<TeacherStateLog> ls = TeacherStateLogServiceImpl.searchTeacherStateLog(teacherId);
			map.put(Constant.DATA, ls);
			map.put(Constant.SUCCESS, true);
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	//设置学生离校，返校
	@RequestMapping("/updateTeacherState.do")
	public void updateTeacherState(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		String leaveDate = request.getParameter("leaveDate");
		String leaveReason = request.getParameter("leaveReason");
		int oldState = NumberUtils.toInt(request.getParameter("oldState"));
		int newState = NumberUtils.toInt(request.getParameter("newState"));
		
		if(isTeacherPrivilege(request,teacherId)){
			map.put(Constant.SUCCESS, TeacherStateLogServiceImpl.updateTeacherState(getSysUser(request),teacherId,oldState,newState,leaveDate,leaveReason));
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
}
