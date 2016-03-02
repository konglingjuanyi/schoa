package com.hao.schoa.controller.teaching;

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
import com.hao.schoa.po.Kecheng;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.TeacherKaoqin;
import com.hao.schoa.po.TeacherKaoqinPeer;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.ClassesServiceImpl;
import com.hao.schoa.service.KaoqinServiceImpl;
import com.hao.schoa.service.PaikeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.TeacherChuqinServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 上课出勤
 * @author haoguowei
 *
 */
@Controller
public class TeachKaoqinController extends BaseSchoa{

	@RequestMapping("/initShangkeChuqin.do")
	public String initShangkeChuqin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		
		boolean admin = isAdminRole(member.getRoleId());
		
		int xueqi = NumberUtils.toInt(request.getParameter("xueqi"));
		int classes = NumberUtils.toInt(request.getParameter("classes"));
		String weeks = request.getParameter("weeks");
		
		request.setAttribute("xueqi", xueqi);
		request.setAttribute("classes", classes);
		request.setAttribute("weeks", weeks);
		
		
		List<Xueqi> xuqis = null;
		if(admin){
			xuqis = XueqiServiceImpl.getAllXueqiList();
		}else{
			xuqis = XueqiServiceImpl.getTeacherXueqiList(member.getTeacherId());
		}
		request.setAttribute("xueqiList", xuqis);
		request.setAttribute("admin", admin);
		
		if(xueqi > 0){
			List<Classes> classList = null;
			if(admin){
				classList = ClassesServiceImpl.getClassesList(xueqi);
			}else{
				classList = ClassesServiceImpl.getTeacherClassesList(xueqi,member.getTeacherId());
			}
			request.setAttribute("classList", classList);
			
			List<String> weekList = XueqiServiceImpl.getWeeksByXueqi(xueqi);
			request.setAttribute("weekList", weekList);
		}
		
		if(classes > 0 && StringUtils.isNotBlank(weeks)){
			String tp[] = weeks.split("~");
			String start = tp[0], end = tp[1]; 
			//获取班级排课Map  key-星期(0-6)	value-排好的课程列表
			Map<Integer,List<ClassesKecheng>> map = KaoqinServiceImpl.getClassesKechengMap(classes);
			Map<Integer,ContainerPaikeModel> model = KaoqinServiceImpl.getPaikeModelMap(start,end);
			for(int wk : model.keySet()){
				model.get(wk).setLs(map.get(wk));
			}
			map = null;
			request.setAttribute("modelMap", model);
			
			//加载考勤
			Map<String,String> kaoqinMap = TeacherChuqinServiceImpl.getKaoqin(classes,start,end);
			request.setAttribute("kaoqinMap", kaoqinMap);
		}
		
		request.setAttribute("kaoqinTypes", Constant.teacherChuqinMap);
		
		return teachingJSP("shangkeChuqin");
	}
	
	@RequestMapping("/saveTeacherShangkeChuqin.do")
	public void saveTeacherShangkeChuqin(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Map<String,String> map = new HashMap<String, String>();
		map.put(Constant.SUCCESS, "false");
		
		int paikeId = NumberUtils.toInt(request.getParameter("paikeId"));
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		int chuqin = NumberUtils.toInt(request.getParameter("chuqin"));
		String day = request.getParameter("day");
		String remark = request.getParameter("remark");
		
		try {
			TeacherKaoqin kq = TeacherChuqinServiceImpl.getChuqin(paikeId, teacherId, day);
			if(kq == null){
				kq = new TeacherKaoqin();
				kq.setKaoqinRemark(remark);
				kq.setKaoqin(chuqin);
				kq.setTeacherId(teacherId);
				kq.setDay(Constant.DATE.parse(day));
				kq.setClassesKechengId(paikeId);
				
				TeacherKaoqinPeer.doInsert(kq);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"新增教师上课出勤记录:"+kq.toString());
			}else{
				if(kq.getKaoqin() != chuqin){
					kq.setKaoqin(chuqin);
					kq.setKaoqinRemark(remark);
					TeacherKaoqinPeer.doUpdate(kq);
					SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改教师上课出勤记录:"+kq.toString());
				}
			}
			map.put(Constant.SUCCESS, "true");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/initChuqinInfo.do")
	public String initChuqinInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member = getSysMember(request);
		if(member == null){
			return NOPRIVILEGES;
		}
		
		boolean admin = isAdminRole(member.getRoleId());
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		
		List<Xueqi> xuqis = null;
		List<Classes> classList = null;
		List<Kecheng> kechengList = null;
		
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
		
		request.setAttribute("xueqiList", xuqis);
		request.setAttribute("classList", classList);
		request.setAttribute("kechengList", kechengList);
		
		request.setAttribute("admin", admin);
		
		return teachingJSP("chuqinInfo");
	}
	
	@RequestMapping("/searchChuqinInfo.do")
	public void searchChuqinInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));

		Map<String, Object> map = TeacherChuqinServiceImpl.getKechengChuqinInfoMap(classesId, kechengId);
		response.getWriter().write(new Gson().toJson(map));
	}
}
