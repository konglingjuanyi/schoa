package com.hao.schoa.controller;

import java.io.IOException;
import java.util.Date;
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
import com.hao.schoa.po.Xueqi;
import com.hao.schoa.po.XueqiPeer;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.XueqiServiceImpl;
import com.hao.schoa.tools.Constant;

@Controller
public class XueqiController extends BaseSchoa{

	@RequestMapping("/initXueqi.do")
	public String initXueqi(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "manager/xueqi";
	}
	
	@RequestMapping("/initEditXueqi.do")
	public String initEditXueqi(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Xueqi xueqi = XueqiServiceImpl.getById(id);
		
		if(id > 0 && XueqiServiceImpl.isHaveKaoqin(id)){
			request.setAttribute("haveKaoqin", 1);
		}
		
		request.setAttribute("xueqi", xueqi);
		return "manager/xueqiEdit";
	}

	@RequestMapping("/searchXueqi.do")
	public void searchXueqi(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		Map<String, Object> map = XueqiServiceImpl.searchXueqi(name);
		response.getWriter().write(new Gson().toJson(map));
	}

	@RequestMapping("/saveXueqi.do")
	public String saveXueqi(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		String name = request.getParameter("name");
		int shuxing = NumberUtils.toInt(request.getParameter("hideShuxing"));
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		Date sdt = null;
		Date set = null;
		try {
			if(StringUtils.isNotBlank(startDate)){
				sdt = Constant.DATE.parse(startDate);
			}
			if(StringUtils.isNotBlank(startDate)){
				set = Constant.DATE.parse(endDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
	
		Xueqi xueqi = null;
		try {
			if(id == 0){
				xueqi = new Xueqi();
				xueqi.setName(name);
				xueqi.setStartDate(sdt);
				xueqi.setEndDate(set);
				xueqi.setShuxing(shuxing);
				
				XueqiPeer.doInsert(xueqi);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"添加学期："+xueqi.toString());
			}else{
				xueqi = XueqiServiceImpl.getById(id);
				xueqi.setName(name);
				xueqi.setShuxing(shuxing);
				
				if(!XueqiServiceImpl.isHaveKaoqin(id)){
					xueqi.setStartDate(sdt);
					xueqi.setEndDate(set);
				}
				
				XueqiPeer.doUpdate(xueqi);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改学期："+xueqi.toString());
			}
			return setSuccessAttribute(request, "学期管理", "initXueqi.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	/**
	 * 学期下所有周
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getXueqiWeeks.do")
	public void getXueqiWeeks(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int xueqiId = NumberUtils.toInt(request.getParameter("xueqiId"));
		List<String> ls = XueqiServiceImpl.getWeeksByXueqi(xueqiId);
//		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(new Gson().toJson(ls));
	}
}
