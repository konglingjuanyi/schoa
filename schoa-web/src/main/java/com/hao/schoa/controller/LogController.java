package com.hao.schoa.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.tools.Constant;

@Controller
public class LogController extends BaseSchoa{

	@RequestMapping("/initLog.do")
	public String initLog(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "manager/log";
	}
	
	@RequestMapping("/searchLogs.do")
	public void searchLogs(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		
		Map<String, Object> map = SchoaLogsServiceImpl.searchLogs(name,start,limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	
}
