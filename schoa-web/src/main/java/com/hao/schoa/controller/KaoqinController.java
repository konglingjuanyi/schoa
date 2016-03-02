package com.hao.schoa.controller;

import java.io.IOException;
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
import com.hao.schoa.container.ContainerPaikeModel;
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.ClassesKecheng;
import com.hao.schoa.po.Kaoqin;
import com.hao.schoa.po.KaoqinPeer;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Student;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.KaoqinServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.StudentServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

@Controller
public class KaoqinController extends BaseSchoa{

	@RequestMapping("/initKaoqin.do")
	public String initKaoqin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqi"));
		int classesId = NumberUtils.toInt(request.getParameter("classes"));
		String weeks = request.getParameter("weeks");
		
		request.setAttribute("xueqi", xueqiId);
		request.setAttribute("classes", classesId);
		request.setAttribute("weeks", weeks);
		
		Member member = getSysMember(request);
		boolean admin = isAdminRole(member.getRoleId());
		
		//考勤异常类型选择
		request.setAttribute("kaoqinTypes", Constant.kaoqinTypeMap);
		
		List<Xueqi> xuqis = null;
		if(admin){
			xuqis = XueqiServiceImpl.getAllXueqiList();
		}else{
			xuqis = XueqiServiceImpl.getTeacherXueqiList(member.getTeacherId());
		}
		
		List<Classes> classList = null;
		if(xueqiId > 0){
			if(admin){
				classList = ClassesServiceImpl.getClassesList(xueqiId);
			}else{
				classList = ClassesServiceImpl.getTeacherClassesList(xueqiId,member.getTeacherId());
			}
			
			List<String> weekList = XueqiServiceImpl.getWeeksByXueqi(xueqiId);
			request.setAttribute("weekList", weekList);
		}
		
		request.setAttribute("xueqiList", xuqis);
		request.setAttribute("classList", classList);
		
		if(classesId > 0 && StringUtils.isNotBlank(weeks)){
			String tp[] = weeks.split("~");
			String start = tp[0], end = tp[1]; 
			//获取班级排课Map  key-星期(0-6)	value-排好的课程列表
			Map<Integer,List<ClassesKecheng>> map = KaoqinServiceImpl.getClassesKechengMap(classesId);
			Map<Integer,ContainerPaikeModel> model = KaoqinServiceImpl.getPaikeModelMap(start,end);
			for(int wk : model.keySet()){
				model.get(wk).setLs(map.get(wk));
			}
			map = null;
			request.setAttribute("modelMap", model);
			
			//加载班级下所有学生
			List<Student> stus = StudentServiceImpl.searchClassesStudent(classesId);
			request.setAttribute("stuList", stus);
			
			//加载学生考勤
			Map<String,String> kaoqinMap = KaoqinServiceImpl.getKaoqin(classesId,start,end);
			request.setAttribute("kaoqinMap", kaoqinMap);
			
			//是否可修改考勤
//			boolean canmodifiy = true;
//			if(!admin && LockServiceImpl.isLockKaoqin(xueqiId, classesId, start, end)){
//				canmodifiy = false;
//			}
//			request.setAttribute("canmodifiy", canmodifiy);
			
			//暂时改为只有管理员才能修改考勤
			request.setAttribute("canmodifiy", admin?true:false);
		}
		
		return "manager/kaoqin";
	}
	
	@RequestMapping("/saveKaoqin.do")
	public void saveKaoqin(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Map<String,String> map = new HashMap<String, String>();
		map.put(Constant.SUCCESS, "false");
		
		int paikeId = NumberUtils.toInt(request.getParameter("paikeId"));
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		int kaoqinValue = NumberUtils.toInt(request.getParameter("kaoqin"));
		String day = request.getParameter("day");
		try {
			Kaoqin kq = KaoqinServiceImpl.getKaoqin(paikeId, studentId, day);
			if(kq == null){
				kq = new Kaoqin();
				kq.setClassesKechengId(paikeId);
				kq.setStudentId(studentId);
				kq.setKaoqin(kaoqinValue);
			
				kq.setDay(Constant.DATE.parse(day));
				KaoqinPeer.doInsert(kq);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"新增考勤记录:"+kq.toString());
			}else{
				if(kq.getKaoqin() != kaoqinValue){
					kq.setKaoqin(kaoqinValue);
					KaoqinPeer.doUpdate(kq);
					SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改考勤记录:"+kq.toString());
				}
			}
			map.put(Constant.SUCCESS, "true");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/initClassesChuqinPage.do")
	public String initClassesKaoqinPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		Classes banji = ClassesServiceImpl.retrieveByPK(classesId);
		List<String> weekList = null;
		if(banji != null){
			weekList = XueqiServiceImpl.getWeeksByXueqi(banji.getXueqiId());
		}
		
		request.setAttribute("weekList", weekList);
		request.setAttribute("classesId", classesId);
		request.setAttribute("banji", banji);
		
		return "manager/printClassesChuqinPage";
	}
	
	@RequestMapping("/initStudentChuqinPage.do")
	public String initStudentChuqinPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int studentId = NumberUtils.toInt(request.getParameter("studentId"));
		
		Classes banji = ClassesServiceImpl.retrieveByPK(classesId);
		Student student = StudentServiceImpl.retrieveByPK(studentId);
		
		List<String> weekList = null;
		if(banji != null){
			weekList = XueqiServiceImpl.getWeeksByXueqi(banji.getXueqiId());
		}
		
		request.setAttribute("weekList", weekList);
		request.setAttribute("classesId", classesId);
		request.setAttribute("studentId", studentId);
		request.setAttribute("banji", banji);
		request.setAttribute("student", student);
		
		return "manager/printStudentChuqinPage";
	}
	
}
