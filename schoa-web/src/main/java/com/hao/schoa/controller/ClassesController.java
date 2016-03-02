package com.hao.schoa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.container.ContainerKechengbiao;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.ClassesPeer;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Student;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.service.TeacherServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

@Controller
public class ClassesController extends BaseSchoa{

	@RequestMapping("/initClasses.do")
	public String initClasses(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Xueqi> xuqis = XueqiServiceImpl.getAllXueqiList();
		request.setAttribute("xueqis", xuqis);
		return "manager/classes";
	}
	
	@RequestMapping("/initClassesInfos.do")
	public String initClassesInfos(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Xueqi> xuqis = XueqiServiceImpl.getAllXueqiList();
		request.setAttribute("xueqis", xuqis);
		
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int xueqi = NumberUtils.toInt(request.getParameter("xueqi"));
		
		if(classesId > 0){
			Classes classes = ClassesServiceImpl.getById(classesId);
			request.setAttribute("classes", classes);
			
			List<Teacher> teachers = ClassesServiceImpl.getClassTeachers(xueqi,classesId);
			request.setAttribute("teachers", teachers);
			
			List<Student> students = StudentServiceImpl.searchClassesStudent(classesId);
			request.setAttribute("students", students);
			
			//课程表数据
			ContainerKechengbiao kechengbiao = PaikeServiceImpl.searcheKechengbiao(classesId);
			request.setAttribute("kechengbiao", kechengbiao);
		}
		request.setAttribute("classesId", classesId);
		request.setAttribute("xueqi", xueqi);
		return "manager/classesInfos";
	}
	
	/**
	 * 班级下的学生
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initClassesStudents.do")
	public String initClassesStudents(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		Classes classes = ClassesServiceImpl.retrieveByPK(classesId);
		request.setAttribute("classes", classes);
		return "manager/classesStudents";
	}

	@RequestMapping("/initEditClasses.do")
	public String initEditClasses(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Classes clazz = ClassesServiceImpl.getById(id);

		List<Xueqi> xuqis = XueqiServiceImpl.getAllXueqiList();
		request.setAttribute("xueqis", xuqis);

		List<Teacher> teacherIds = TeacherServiceImpl.searchTeachersAsList();
		request.setAttribute("teacherIds", teacherIds);

		request.setAttribute("clazz", clazz);
		return "manager/classesEdit";
	}

	@RequestMapping("/searchClasses.do")
	public void searchClasses(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int xueqi = NumberUtils.toInt(request.getParameter("xueqi"));
		
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		
		Map<String, Object> map = ClassesServiceImpl.search(xueqi,start,limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 查询班级下的所有学生
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchClasseStudentGrid.do")
	public void searchClasseStudentGrid(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		Map<String, Object> map = StudentServiceImpl.searchClassesStudentMap(classesId);
		response.getWriter().write(new Gson().toJson(map));
	}
	/**
	 * 查询班级所在学期下没有排课的学生
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/searchOtherStu.do")
	public void searchOtherStu(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		String name = request.getParameter("name");
		String huzhao = request.getParameter("huzhao");
		Map<String, Object> map = StudentServiceImpl.searchOtherStuMap(classesId, name, huzhao);
		response.getWriter().write(new Gson().toJson(map));
	}
	/**
	 * 学生移出班级
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/stuMoveoutClass.do")
	public void stuMoveoutClass(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		boolean ok = StudentServiceImpl.stuMoveoutClass(classesId,studentId);
		
		SchoaLogsServiceImpl.insertLogs(getSysUser(request), 
				"学生移除班级，classesId:"+classesId+";studentId:"+studentId);
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put(Constant.SUCCESS, ok);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 设置优秀生状态
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/studentYouxiu.do")
	public void studentYouxiu(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		int youxiu = NumberUtils.toInt(request.getParameter("youxiu"), -1);
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(youxiu == -1){
			map.put(Constant.SUCCESS, false);
		}else{
			boolean ok = StudentServiceImpl.studentYouxiu(classesId,studentId,youxiu);
			map.put(Constant.SUCCESS, ok);
		}
		
		SchoaLogsServiceImpl.insertLogs(getSysUser(request), 
				"设置优秀生状态，youxiu:"+youxiu+";classesId:"+classesId+";studentId:"+studentId);
		
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/studentJinbu.do")
	public void studentJinbu(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		int jinbu = NumberUtils.toInt(request.getParameter("jinbu"), -1);
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if(jinbu == -1){
			map.put(Constant.SUCCESS, false);
		}else{
			boolean ok = StudentServiceImpl.studentJinbu(classesId,studentId,jinbu);
			map.put(Constant.SUCCESS, ok);
		}
		
		SchoaLogsServiceImpl.insertLogs(getSysUser(request), 
				"设置进步生状态，jinbu:"+jinbu+";classesId:"+classesId+";studentId:"+studentId);
		
		response.getWriter().write(new Gson().toJson(map));
	}
	
	/**
	 * 班级添加学生
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/addClassesStudent.do")
	public void addClassesStudent(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		String studentIds = request.getParameter("studentIds");
		Classes banji = ClassesServiceImpl.retrieveByPK(classesId);
		boolean ok = StudentServiceImpl.stuAddToClass(classesId, studentIds, banji.getXueqiId());
		
		SchoaLogsServiceImpl.insertLogs(getSysUser(request), 
				"班级添加学生，classesId:"+classesId+";studentIds:"+studentIds+";执行结果：" + ok);
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put(Constant.SUCCESS, ok);
		response.getWriter().write(new Gson().toJson(map));
	}

	@RequestMapping("/delClasses.do")
	public void delClasses(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put(Constant.SUCCESS, false);
		try {
			ClassesPeer.executeStatement("delete from "
					+ ClassesPeer.TABLE_NAME + " where id=" + id);

			SchoaLogsServiceImpl.insertLogs(getSysUser(request), 
					"删除班级，classesId:"+id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(Constant.SUCCESS, true);
		response.getWriter().write(new Gson().toJson(map));
	}

	@RequestMapping("/saveClasses.do")
	public String saveClasses(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		String rmark = request.getParameter("rmark");
		String name = request.getParameter("name");

		Xueqi xueqi = XueqiServiceImpl.getById(xueqiId);

		Classes clazz = null;
		try {
			if (id == 0) {
				clazz = new Classes();
				clazz.setName(name);
				clazz.setRmark(rmark);
				clazz.setXueqiId(xueqiId);
				clazz.setTeacherId(teacherId);

				if (xueqi != null) {
					clazz.setStartDate(xueqi.getStartDate());
					clazz.setEndDate(xueqi.getEndDate());
				}

				ClassesPeer.doInsert(clazz);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request), 
						"新创建班级"+clazz.toString());
			} else {
				clazz = ClassesServiceImpl.getById(id);
				clazz.setName(name);
				clazz.setRmark(rmark);
				clazz.setXueqiId(xueqiId);
				clazz.setTeacherId(teacherId);

				if (xueqi != null) {
					clazz.setStartDate(xueqi.getStartDate());
					clazz.setEndDate(xueqi.getEndDate());
				}

				ClassesPeer.doUpdate(clazz);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request), "修改班级"+clazz.toString());
			}
			return setSuccessAttribute(request, "班级管理", "initClasses.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}

	@RequestMapping("/getClassesByXueqiId.do")
	public void getClassesByXueqiId(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Member member = getSysMember(request);
		boolean admin = isAdminRole(member.getRoleId());
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int privilege = NumberUtils.toInt(request.getParameter("privilege"), 0); //privilege＝1表示权限查询
		
		List<Classes> list = null;
		if (xueqiId == 0) {
			list = new ArrayList<Classes>();
		} else {
			if(privilege == 1){
				if(admin){
					list = ClassesServiceImpl.getClassesList(xueqiId);
				}else{
					list = ClassesServiceImpl.getTeacherClassesList(xueqiId,member.getTeacherId());
				}
			}else{
				list = ClassesServiceImpl.getClassesList(xueqiId);
			}
		}
		
//		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(new Gson().toJson(list));
	}
	
}
