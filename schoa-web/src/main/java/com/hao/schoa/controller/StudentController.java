package com.hao.schoa.controller;

import java.io.IOException;
import java.text.ParseException;
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
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.Country;
import com.hao.schoa.po.Score;
import com.hao.schoa.po.Student;
import com.hao.schoa.po.StudentPeer;
import com.hao.schoa.po.StudentStateLog;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.service.StudentStateLogServiceImple;
import com.hao.schoa.service.SystemServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

@Controller
public class StudentController extends BaseSchoa{

	@RequestMapping("/initStudent.do")
	public String initStudent(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Xueqi> xuqis = XueqiServiceImpl.getAllXueqiList();
		request.setAttribute("xueqis", xuqis);
		return "manager/student";
	}
	
	@RequestMapping("/initStudentInfos.do")
	public String initStudentInfos(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		if(id > 0){
			Student stu = StudentServiceImpl.getById(id);
			request.setAttribute("student", stu);
			
			//学生所在班级及各科成绩
			Map<Classes,List<Score>> classesScoreMap = StudentServiceImpl.getClassesScoreMap(stu.getId());
			request.setAttribute("classesScoreMap", classesScoreMap);
		}
		return "manager/studentInfos";
	}
	
	@RequestMapping("/initImportStudents.do")
	public String initImportStudents(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "manager/importStudent";
	}
	@RequestMapping("/initImportStudentsCode.do")
	public String initImportStudentsCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "manager/importStudentsCode";
	}
	
	@RequestMapping("/initEditStudent.do")
	public String initEditStudent(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int id = NumberUtils.toInt(request.getParameter("id"));
		Student student = StudentServiceImpl.getById(id);
		request.setAttribute("student", student);
		
		List<Country> countryList = SystemServiceImpl.getAllCountry();
		request.setAttribute("countryList", countryList);
		
		//经费来源
		request.setAttribute("costFromMap", Constant.costFromMap);
		
		//学生来源
		request.setAttribute("stuFromMap", Constant.stuFromMap);
		
		return "manager/studentEdit";
	}

	@RequestMapping("/searchStudents.do")
	public void searchStudents(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name = request.getParameter("sname");
		String huzhao = request.getParameter("huzhao");
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), 100);
		
		Map<String, Object> map = StudentServiceImpl.searchStudents(huzhao,name,start,limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping("/searchStudentsByXueqi.do")
	public void searchStudentsByXueqi(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		Map<String, Object> map = StudentServiceImpl.searchStudentsByXueqi(xueqiId,start,limit);
		response.getWriter().write(new Gson().toJson(map));
	}

	@RequestMapping("/saveStudent.do")
	public String saveStudent(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		int code = NumberUtils.toInt(request.getParameter("code"));
		int country = NumberUtils.toInt(request.getParameter("country"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int sex = NumberUtils.toInt(request.getParameter("sex"));
		int costFrom = NumberUtils.toInt(request.getParameter("costFrom"));
		String ename = request.getParameter("ename");
		String cname = request.getParameter("cname");
		String headPic = request.getParameter("hideHeadPic");
		String birthday = request.getParameter("birthday");
		String passNumb = request.getParameter("passNumb");
		String address = request.getParameter("address");
		String closedDate = request.getParameter("closedDate");
		int stuFrom = NumberUtils.toInt(request.getParameter("stuFrom"));
		
		Date dt = null;
		if(StringUtils.isNotBlank(closedDate)){
			try {
				dt = Constant.DATE.parse(closedDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		Student stu = null;
		try {
			if(id == 0){
				stu = new Student();
				stu.setCode(code);
				stu.setPhone(phone);
				stu.setEmail(email);
				stu.setEname(ename);
				stu.setCname(cname);
				stu.setHeadPic(headPic);
				stu.setSex(sex);
				stu.setPassNumb(passNumb);
				stu.setBirthday(birthday);
				stu.setNation(country);
				stu.setClosedDate(dt);
				stu.setAddress(address);
				stu.setCostFrom(costFrom);
				stu.setStuFrom(stuFrom);
				StudentPeer.doInsert(stu);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"添加学生："+stu.toString());
			}else{
				stu = StudentServiceImpl.getById(id);
				stu.setCode(code);
				stu.setPhone(phone);
				stu.setEmail(email);
				stu.setEname(ename);
				stu.setCname(cname);
				stu.setHeadPic(headPic);
				stu.setSex(sex);
				stu.setPassNumb(passNumb);
				stu.setBirthday(birthday);
				stu.setNation(country);
				stu.setClosedDate(dt);
				stu.setAddress(address);
				stu.setCostFrom(costFrom);
				stu.setStuFrom(stuFrom);
				StudentPeer.doUpdate(stu);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改学生："+stu.toString());
			}
			return setSuccessAttribute(request, "学生管理", "initStudent.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	@RequestMapping("/delStudent.do")
	public void delStudent(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put(Constant.SUCCESS, false);
		try {
			StudentPeer.executeStatement("delete from "+StudentPeer.TABLE_NAME +" where id="+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(Constant.SUCCESS, true);
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"删除学生，id："+id);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/getStudentById.do")
	public void getStudentById(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("id"));
		Student stu = StudentServiceImpl.getById(id);
		response.getWriter().write(new Gson().toJson(stu));
	}
	
	//学生离校记录
	@RequestMapping("/showStudentStateLogs.do")
	public void showStudentStateLogs(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		if(studentId > 0){
			List<StudentStateLog> ls = StudentStateLogServiceImple.searchStudentStateLog(studentId);
			map.put(Constant.DATA, ls);
			map.put(Constant.SUCCESS, true);
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	//设置学生离校，返校
	@RequestMapping("/updateStudentState.do")
	public void updateStudentState(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		String leaveDate = request.getParameter("leaveDate");
		String leaveReason = request.getParameter("leaveReason");
		int oldState = NumberUtils.toInt(request.getParameter("oldState"));
		int newState = NumberUtils.toInt(request.getParameter("newState"));
		
		if(studentId > 0){
			map.put(Constant.SUCCESS, StudentServiceImpl.updateStudentState(getSysUser(request),studentId,oldState,newState,leaveDate,leaveReason));
		}else{
			map.put(Constant.SUCCESS, false);
		}
		response.getWriter().write(new Gson().toJson(map));
	}
}
