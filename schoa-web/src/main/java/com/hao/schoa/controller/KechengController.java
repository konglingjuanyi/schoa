package com.hao.schoa.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.hao.schoa.container.JiaoxueFileScore;
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.KechengPeer;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.KechengServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.TeacherServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

@Controller
public class KechengController extends BaseSchoa{

	@RequestMapping("/initKecheng.do")
	public String initKecheng(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		
		boolean admin = isAdminRole(member.getRoleId());
		
		List<Xueqi> xuqis = null;
		List<Teacher> teachers = null;
		
		if(admin){
			xuqis = XueqiServiceImpl.getAllXueqiList();
			teachers = TeacherServiceImpl.searchTeachersAsList();
		}else{
			xuqis = XueqiServiceImpl.getTeacherXueqiList(member.getTeacherId());
			teachers = new ArrayList<Teacher>();
			teachers.add(member.getTeacher());
		}
		
		request.setAttribute("xueqis", xuqis);
		request.setAttribute("teachers", teachers);
		
		return "manager/kecheng";
	}
	
	@RequestMapping("/searchKechengs.do")
	public void searchKechengs(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int xueqi = NumberUtils.toInt(request.getParameter("xueqi"));
		int teacher = NumberUtils.toInt(request.getParameter("teacher"));
		String name = request.getParameter("name");
		
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		
		Member member = getSysMember(request);
		if(!isAdminPrivilege(member)){
			teacher = member.getTeacherId();
		}
		
		Map<String, Object> map = KechengServiceImpl.searchGrid(xueqi,teacher,name,start,limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/initEditKecheng.do")
	public String initEditKecheng(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		
		Kecheng kecheng = KechengServiceImpl.getById(id);
		request.setAttribute("kecheng", kecheng);
		
		List<Xueqi> xuqis = XueqiServiceImpl.getAllXueqiList();
		request.setAttribute("xueqis", xuqis);
		
		List<Teacher> teachers = null;
		
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		if(isAdminRole(member.getRoleId())){
			teachers = TeacherServiceImpl.searchTeachersAsList();
		}else{
			teachers = new ArrayList<Teacher>();
			teachers.add(member.getTeacher());
		}
		request.setAttribute("teachers", teachers);
		
		//教学文件列表
		Map<Integer,JiaoxueFileScore> fileFlagMap = Constant.fileFlagMap;
		request.setAttribute("fileFlagMap", fileFlagMap);
		
		return "manager/kechengEdit";
	}
	
	@RequestMapping("/saveKecheng.do")
	public String saveKecheng(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int keshi = NumberUtils.toInt(request.getParameter("keshi"));
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		String name = request.getParameter("name");
		String jiaocai = request.getParameter("jiaocai");
		String intro = request.getParameter("intro");
		
		String fileFlag = request.getParameter("fileFlags");
		
		//只能为自己创建课程
		if(!isTeacherPrivilege(request,teacherId)){
			return NOPRIVILEGES;
		}
		
		//验证需上传得文件得分总和是否为20分
		if(StringUtils.isNotBlank(fileFlag)){
			double sum = 0;
			String[] fs = fileFlag.split(",");
			for(String f:fs){
				JiaoxueFileScore obj = Constant.fileFlagMap.get(Integer.parseInt(f));
				sum += obj.getScore();
			}
			
			if(sum - Constant.sc_teacher_file != 0){
				setErrorAttribute(request, "课程需上传的文件的总分数为" + Constant.sc_teacher_file + "分，请重新选择需上传的教学文件！");
				return FAIL;
			}
		}
		
		
		Kecheng kecheng= null;
		try {
			if(id == 0){
				if(!isAdminPrivilege(request)){
					return NOPRIVILEGES;
				}
				
				kecheng = new Kecheng();
				kecheng.setName(name);
				kecheng.setIntro(intro);
				kecheng.setXueqiId(xueqiId);
				kecheng.setTeacherId(teacherId);
				kecheng.setKeshi(keshi);
				kecheng.setJiaocai(jiaocai);
				kecheng.setFileUploadFlags(fileFlag);
				
				KechengPeer.doInsert(kecheng);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"新增课程:"+kecheng.toString());
			}else{
				if(!isTeacherPrivilege(request, teacherId)){
					return NOPRIVILEGES;
				}
				
				kecheng = KechengServiceImpl.retrieveByPK(id);
				kecheng.setName(name);
				kecheng.setIntro(intro);
				kecheng.setXueqiId(xueqiId);
				kecheng.setTeacherId(teacherId);
				kecheng.setKeshi(keshi);
				kecheng.setJiaocai(jiaocai);
				kecheng.setFileUploadFlags(fileFlag);
			
				KechengPeer.doUpdate(kecheng);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改课程:"+kecheng.toString());
			}
			return setSuccessAttribute(request, "课程信息", "initKecheng.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	@RequestMapping("/getKechengByXueqiId.do")
	public void getKechengByXueqiId(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int pri = NumberUtils.toInt(request.getParameter("pri")); //pri等于1，表示根据权限取数据
		
		List<Kecheng> list = null;
		if(xueqiId == 0){
			list = new ArrayList<Kecheng>();
		}else{
			list = KechengServiceImpl.getKechengList(xueqiId,0,"");
		}
		
		//根据权限取数据
		if(pri == 1 && !isAdminPrivilege(request)){
			Member member = getSysMember(request);
			List<Kecheng> resultList = new ArrayList<Kecheng>();
			int teacherId = member.getTeacherId();
			
			for(Kecheng kch : list){
				if(kch.getTeacherId() == teacherId){
					resultList.add(kch);
				}
			}
			response.getWriter().write(new Gson().toJson(resultList));
		}else{
			response.getWriter().write(new Gson().toJson(list));
		}
		
	}
	
	@RequestMapping("/getKechengByClassesId.do")
	public void getKechengByClassesId(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int privilege = NumberUtils.toInt(request.getParameter("privilege"), 0);
		List<Kecheng> list = null;
		
		Member member = getSysMember(request);
		boolean admin = isAdminRole(member.getRoleId());
		
		if(classesId == 0){
			list = new ArrayList<Kecheng>();
		}else{
			int teacherId = 0;
			if(privilege == 1 && !admin){
				teacherId = member.getTeacherId();
			}
			
			list = PaikeServiceImpl.getClassesKecheng(classesId, teacherId);
		}
		response.getWriter().write(new Gson().toJson(list));
	}
	
}
