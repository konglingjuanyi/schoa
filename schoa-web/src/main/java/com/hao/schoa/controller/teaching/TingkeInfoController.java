package com.hao.schoa.controller.teaching;

import java.io.IOException;
import java.util.Date;
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
import com.hao.schoa.po.Classes;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.Tingke;
import com.hao.schoa.po.TingkePeer;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.KechengServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.TeacherServiceImpl;
import com.hao.schoa.service.TingkeServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 听课情况
 * @author haoguowei
 *
 */
@Controller
public class TingkeInfoController extends BaseSchoa{

	@RequestMapping("/initTingkeInfo.do")
	public String initTingkeInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		
		boolean admin = isAdminRole(member.getRoleId());
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		
		List<Xueqi> xuqis = null;
		List<Classes> classList = null;
		List<Kecheng> kechengList = null;
		
		List<Teacher> teachers = TeacherServiceImpl.searchTeachersAsList();
		request.setAttribute("teachers", teachers);
		
		if(admin){
			xuqis = XueqiServiceImpl.getAllXueqiList();
		}else{
			xuqis = XueqiServiceImpl.getTeacherXueqiList(member.getTeacherId());
		}
		
		if(xueqiId > 0){
			classList = ClassesServiceImpl.getClassesList(xueqiId);
		}
		
		if(classesId > 0){
			kechengList = PaikeServiceImpl.getClassesKecheng(classesId);
		}
		
		request.setAttribute("xueqiId", xueqiId);
		request.setAttribute("classesId", classesId);
		request.setAttribute("kechengId", kechengId);
		request.setAttribute("teacherId", teacherId);
		
		request.setAttribute("xueqiList", xuqis);
		request.setAttribute("classList", classList);
		request.setAttribute("kechengList", kechengList);
		
		request.setAttribute("admin", admin);
		
		return teachingJSP("tingke");
	}
	
	@RequestMapping("/initEditTingke.do")
	public String initEditTingke(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		
		Tingke tingke = TingkeServiceImpl.getTingkeById(id);
		List<Xueqi> xuqis = XueqiServiceImpl.getAllXueqiList();
		
		List<Teacher> teachers = TeacherServiceImpl.searchTeachersAsList();
		request.setAttribute("teachers", teachers);
		
		request.setAttribute("tingke", tingke);
		request.setAttribute("xueqiList", xuqis);
		
		return teachingJSP("editTingke");
	}
	
	
	@RequestMapping("/searchTingke.do")
	public void searchTingke(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int selfTeacherId = 0;
		Member member = getSysMember(request);
		if(member == null){
			selfTeacherId = -1;
		}else{
			selfTeacherId = isAdminRole(member.getRoleId()) ? 0 : member.getTeacherId();
		}
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));

		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);

		Map<String, Object> map = TingkeServiceImpl.search(selfTeacherId, xueqiId, classesId, kechengId, teacherId,
				start, limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	
	/**
	 * 删除听课情况
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteTingke.do")
	public void deleteTingke(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("id"));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		
		map.put(Constant.SUCCESS, TingkeServiceImpl.deleteTingke(id));
		
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"删除听课情况，id＝"+id);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/saveTingke.do")
	public String saveTingke(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		int duxieTeacherId = NumberUtils.toInt(request.getParameter("duxieTeacherId"));
		
		Teacher duxieTeacher = TeacherServiceImpl.getById(duxieTeacherId);
		
		Kecheng kecheng = KechengServiceImpl.getById(kechengId);
		int teacherId = kecheng.getTeacherId();
		String teacherName = kecheng.getTeacher()==null?"":kecheng.getTeacher().getName();
		
		double score = NumberUtils.toDouble(request.getParameter("score"));
		
		String remark = request.getParameter("remark");
		String tingkeTime = request.getParameter("tingkeTime");
		
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		
		Tingke tingke= null;
		try {
			if(id == 0){
				tingke = new Tingke();
				
				tingke.setXueqiId(xueqiId);
				tingke.setBanjiId(classesId);
				tingke.setKechengId(kechengId);
				tingke.setTeacherId(teacherId);
				tingke.setTeacherName(teacherName);
				tingke.setDuxieTeacherId(duxieTeacherId);
				tingke.setDuxieTeacherName(duxieTeacher==null?"":duxieTeacher.getName());
				tingke.setTingkeTime(tingkeTime);
				tingke.setRemark(remark);
				tingke.setScore(score);
				tingke.setMemberId(member.getId());
				tingke.setMemberName(member.getName());
				tingke.setUpdateTime(new Date());
				
				
				TingkePeer.doInsert(tingke);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"新增听课情况:"+tingke.toString());
			}else{
				tingke = TingkeServiceImpl.getTingkeById(id);
				
				tingke.setXueqiId(xueqiId);
				tingke.setBanjiId(classesId);
				tingke.setKechengId(kechengId);
				tingke.setTeacherId(teacherId);
				tingke.setTeacherName(teacherName);
				tingke.setDuxieTeacherId(duxieTeacherId);
				tingke.setDuxieTeacherName(duxieTeacher==null?"":duxieTeacher.getName());
				tingke.setTingkeTime(tingkeTime);
				tingke.setRemark(remark);
				tingke.setScore(score);
				tingke.setMemberId(member.getId());
				tingke.setMemberName(member.getName());
				tingke.setUpdateTime(new Date());
				
			
				TingkePeer.doUpdate(tingke);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改听课情况:"+tingke.toString());
			}
			return setSuccessAttribute(request, "听课情况", "initTingkeInfo.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
}
