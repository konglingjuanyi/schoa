package com.hao.schoa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.service.LockServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;

@Controller
public class LockController extends BaseSchoa{

	@RequestMapping("/lockScore.do")
	public void lockScore(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int kechengId = NumberUtils.toInt(request.getParameter("kechengId"));
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		
		LockServiceImpl.lockScore(xueqiId, classesId, kechengId, getSysUser(request));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put("success", true);
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"锁定成绩:kechengId＝"+kechengId+";xueqiId="+xueqiId+";classesId="+classesId);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/lockKaoqin.do")
	public void lockKaoqin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		int classesId = NumberUtils.toInt(request.getParameter("classesId"));
		String weeks = request.getParameter("weeks");
		
		String tp[] = weeks.split("~");
		String start = tp[0];
		String end = tp[1]; 
		
		LockServiceImpl.lockKaoqin(xueqiId, classesId, start, end, getSysUser(request));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put("success", true);
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"锁定考勤:weeks＝"+weeks+";xueqiId="+xueqiId+";classesId="+classesId);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	
}
