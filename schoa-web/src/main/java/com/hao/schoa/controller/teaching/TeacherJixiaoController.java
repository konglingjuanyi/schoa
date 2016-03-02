package com.hao.schoa.controller.teaching;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.DownloadFile;
import com.hao.schoa.UploadFile;
import com.hao.schoa.container.JixiaoKey;
import com.hao.schoa.po.JixiaoWaipin;
import com.hao.schoa.po.JixiaoWaipinPeer;
import com.hao.schoa.po.JixiaoZaibian;
import com.hao.schoa.po.JixiaoZaibianPeer;
import com.hao.schoa.po.Member;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.TeacherJixiaoServiceImpl;
import com.hao.schoa.service.TeacherServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

@Controller
public class TeacherJixiaoController extends BaseSchoa{
	
	@RequestMapping("/initWaipinJixiao.do")
	public String initWaipinJixiao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		List<Xueqi> xuqis = XueqiServiceImpl.getAllXueqiList();
		
		if(xueqiId > 0){
			Map<JixiaoKey,JixiaoWaipin> map = TeacherJixiaoServiceImpl.getWaipinJixiao(xueqiId, 0);
			request.setAttribute("map", map);
		}
		
		request.setAttribute("xueqiId", xueqiId);
		request.setAttribute("xueqiList", xuqis);
		
		return teachingJSP("waipinJixiao");
	}
	@RequestMapping("/initZaibianJixiao.do")
	public String initZaibianJixiao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		List<Xueqi> xuqis = XueqiServiceImpl.getAllXueqiList();
		
		if(xueqiId > 0){
			Map<JixiaoKey,JixiaoZaibian> map = TeacherJixiaoServiceImpl.getZaiBianJixiao(xueqiId, 0);
			request.setAttribute("map", map);
		}
		
		request.setAttribute("xueqiId", xueqiId);
		request.setAttribute("xueqiList", xuqis);
		
		return teachingJSP("zaibianJixiao");
	}
	
	@RequestMapping("/initWaipinHuizong.do")
	public String initWaipinHuizong(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		
		Member member = getSysMember(request);
		if(!isAdminPrivilege(member)){
			teacherId = member.getTeacherId();
		}
		List<Teacher> teacherList = TeacherServiceImpl.searchTeacherList(Constant.teacher_waipin, isAdminPrivilege(member)?0:member.getTeacherId());
		
		Teacher teacher = null;
		Map<JixiaoKey,JixiaoWaipin> map = null; //教师在所有学期下的成绩
		
		if(teacherId > 0){
			teacher = TeacherServiceImpl.getById(teacherId);
			map = TeacherJixiaoServiceImpl.getWaipinJixiao(0, teacherId);
		}
		
		request.setAttribute("teacherList", teacherList);
		request.setAttribute("teacher", teacher);
		request.setAttribute("map", map);
		
		return teachingJSP("waipinHuizong");
	}
	
	
	@RequestMapping("/initEditZaibianJixiao.do")
	public String initEditZaibianJixiao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		
		Xueqi xq = XueqiServiceImpl.getById2(xueqiId);
		Teacher t = TeacherServiceImpl.getById(teacherId);
		
		JixiaoZaibian jixiao = TeacherJixiaoServiceImpl.getJixiaoZaibian(xueqiId, teacherId);
		
		request.setAttribute("jixiao", jixiao);
		request.setAttribute("xueqi", xq);
		request.setAttribute("teacher", t);
		
		return teachingJSP("zaibianJixiaoEdit");
	}
	
	@RequestMapping("/initEditWaipinJixiao.do")
	public String initEditWaipinJixiao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		
		JixiaoWaipin jixiao = TeacherJixiaoServiceImpl.getJixiaoWaipin(xueqiId, teacherId);
		
		Xueqi xq = XueqiServiceImpl.getById2(xueqiId);
		Teacher t = TeacherServiceImpl.getById(teacherId);

		request.setAttribute("xueqi", xq);
		request.setAttribute("teacher", t);
		request.setAttribute("jixiao", jixiao);
		
		return teachingJSP("waipinJixiaoEdit");
	}
	
	@RequestMapping("/saveWaipinTeacherJixiao.do")
	public String saveWaipinTeacherJixiao(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	
			Member member = getSysMember(request);
			if(member == null){
				return NOPRIVILEGES;
			}
			
			int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
			int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
			
			JixiaoWaipin jixiao = TeacherJixiaoServiceImpl.getJixiaoWaipin(xueqiId, teacherId);
			
			jixiao.setXueqiId(xueqiId);
			jixiao.setTeacherId(teacherId);
			
			jixiao.setScKaihui(NumberUtils.toInt(request.getParameter("scKaihui")));
			jixiao.setScKaihuiReason(request.getParameter("scKaihuiReason"));
			
			jixiao.setScHuodong(NumberUtils.toInt(request.getParameter("scHuodong")));
			jixiao.setScHuodongReason(request.getParameter("scHuodongReason"));
			
			jixiao.setScYinxiang(NumberUtils.toInt(request.getParameter("scYinxiang")));
			jixiao.setScYinxiangReason(request.getParameter("scYinxiangReason"));
			
			jixiao.setScGongxian(NumberUtils.toInt(request.getParameter("scGongxian")));
			jixiao.setScGongxianReason(request.getParameter("scGongxianReason"));
			
			jixiao.setRemark(request.getParameter("remark"));
			jixiao.setYouxiu(NumberUtils.toInt(request.getParameter("youxiu")));
			
			jixiao.setMemberId(member.getId());
			jixiao.setMemberName(member.getName());
			jixiao.setUpdateTime(new Date());
	
			try {
				if (jixiao.getId() == 0) {
					JixiaoWaipinPeer.doInsert(jixiao);
					SchoaLogsServiceImpl.insertLogs(getSysUser(request), 
							"新创建外聘教师工作绩效"+jixiao.toString());
				} else {
					JixiaoWaipinPeer.doUpdate(jixiao);
					SchoaLogsServiceImpl.insertLogs(getSysUser(request), "修改外聘教师工作绩效"+jixiao.toString());
				}
				return setSuccessAttribute(request, "外聘教师工作绩效", "initWaipinJixiao.do?xueqiId="+xueqiId);
			} catch (Exception e) {
				e.printStackTrace();
				setErrorAttribute(request, e.getMessage());
			}
		return FAIL;
	}
	
	@RequestMapping("/saveZaibianTeacherJixiao.do")
	public String saveZaibianTeacherJixiao(
			@RequestParam(value = "scKaoheFile", required = false) MultipartFile file, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	
			Member member = getSysMember(request);
			if(member == null){
				return NOPRIVILEGES;
			}
			
			String scKaoheFilePath = "" ;
			String fileName = "" ;
			if(file != null && file.getSize() > 0){
				JsonObject jsonObject = new UploadFile().writeFileToDisk(file);
				fileName = file.getOriginalFilename();
				if(jsonObject.get(Constant.JSON_SUCCESS).getAsBoolean()){
					scKaoheFilePath = jsonObject.get(Constant.JSON_DATA).getAsString();
				}
			}
			
			int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
			int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
			
			JixiaoZaibian jixiao = TeacherJixiaoServiceImpl.getJixiaoZaibian(xueqiId, teacherId);
			
			jixiao.setXueqiId(xueqiId);
			jixiao.setTeacherId(teacherId);
			
			jixiao.setScKaihuiReason(request.getParameter("scKaihuiReason"));
			jixiao.setScBanzhuren(request.getParameter("scBanzhuren"));
			jixiao.setScJianren(request.getParameter("scJianren"));
			jixiao.setScOther(request.getParameter("scOther"));
			jixiao.setScJiang(request.getParameter("scJiang"));
			jixiao.setScGongzuoliang(request.getParameter("scGongzuoliang"));
			jixiao.setScKaoheFile(scKaoheFilePath);
			jixiao.setScKaoheFilename(fileName);
			
			jixiao.setRemark(request.getParameter("remark"));
			jixiao.setYouxiu(NumberUtils.toInt(request.getParameter("youxiu")));
			
			jixiao.setMemberId(member.getId());
			jixiao.setMemberName(member.getName());
			jixiao.setUpdateTime(new Date());
	
			try {
				if (jixiao.getId() == 0) {
					JixiaoZaibianPeer.doInsert(jixiao);
					SchoaLogsServiceImpl.insertLogs(getSysUser(request), 
							"新创建在编教师工作绩效"+jixiao.toString());
				} else {
					JixiaoZaibianPeer.doUpdate(jixiao);
					SchoaLogsServiceImpl.insertLogs(getSysUser(request), "修改在编教师工作绩效"+jixiao.toString());
				}
				return setSuccessAttribute(request, "在编教师工作绩效", "initZaibianJixiao.do?xueqiId="+xueqiId);
			} catch (Exception e) {
				e.printStackTrace();
				setErrorAttribute(request, e.getMessage());
			}
		return FAIL;
	}
	
	@RequestMapping("/downloadZaibianJixiaoFile.do")
	public void downloadZaibianJixiaoFile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int id = NumberUtils.toInt(request.getParameter("id"));
		if (id > 0) {
			JixiaoZaibian jixiao = TeacherJixiaoServiceImpl.getJixiaoById(id);
			
			if(jixiao != null && StringUtils.isNotBlank(jixiao.getScKaoheFile()) && StringUtils.isNotBlank(jixiao.getScKaoheFilename())){
				new DownloadFile().download(
						Constant.IMAGEPATH + "/" + jixiao.getScKaoheFile(),
						jixiao.getScKaoheFilename(),
						request, 
						response);
			}
		} else {
			System.err.println(" downloadZaibianJixiaoFile  error : id=" + id);
		}
	}
	
	@RequestMapping("/initZaibianHuizong.do")
	public String initZaibianHuizong(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		
		Member member = getSysMember(request);
		if(!isAdminPrivilege(member)){
			teacherId = member.getTeacherId();
		}
		
		List<Teacher> teacherList = TeacherServiceImpl.searchTeacherList(Constant.teacher_zhengbian, isAdminPrivilege(member)?0:member.getTeacherId());
		

		Teacher teacher = null;
		Map<JixiaoKey,JixiaoZaibian> map = null; //教师在所有学期下的成绩
		
		if(teacherId > 0){
			teacher = TeacherServiceImpl.getById(teacherId);
			map = TeacherJixiaoServiceImpl.getZaiBianJixiao(0, teacherId);
		}

		request.setAttribute("teacherList", teacherList);
		request.setAttribute("teacher", teacher);
		request.setAttribute("map", map);
		
		return teachingJSP("zaibianHuizong");
	}
	
	@RequestMapping("/getWaipinTeacherJixiaoInfo.do")
	public void getTeacherJixiaoInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(Constant.SUCCESS, false);
		
		try {
			
			if(xueqiId > 0 && teacherId > 0){
				Map<JixiaoKey,JixiaoWaipin> dataMap = TeacherJixiaoServiceImpl.getWaipinJixiao(xueqiId, teacherId);
				JixiaoWaipin wp = dataMap==null?null:dataMap.get(new JixiaoKey(xueqiId,teacherId));
				if(wp != null){
					wp.setTotal(wp.getTotal());
				}
				map.put(Constant.SUCCESS, true);
				map.put(Constant.DATA, wp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping("/getZaibianTeacherJixiaoInfo.do")
	public void getZaibianTeacherJixiaoInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(Constant.SUCCESS, false);
		
		try {
			
			if(xueqiId > 0 && teacherId > 0){
				Map<JixiaoKey,JixiaoZaibian> dataMap = TeacherJixiaoServiceImpl.getZaiBianJixiao(xueqiId, teacherId);
				JixiaoZaibian wp = dataMap==null?null:dataMap.get(new JixiaoKey(xueqiId,teacherId));
				
				map.put(Constant.SUCCESS, true);
				map.put(Constant.DATA, wp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write(new Gson().toJson(map));
	}
}
