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
import com.hao.schoa.service.PrivilegeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.tools.Constant;

/**
 * 权限管理
 * @author haoguowei
 *
 */
@Controller
public class PrivilegeController extends BaseSchoa{

	@RequestMapping("/initPrivileges.do")
	public String initPrivileges(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "manager/privileges";
	}
	
	@RequestMapping("/searchPrivileges.do")
	public void searchPrivileges(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = PrivilegeServiceImpl.search();
		response.getWriter().write(new Gson().toJson(map));
	}
	@RequestMapping("/searchPrivilegesWithoutRoles.do")
	public void searchPrivilegesWithoutRoles(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int role = NumberUtils.toInt(request.getParameter("role"));
		Map<String, Object> map = PrivilegeServiceImpl.searchPrivilegesWithoutRolesMap(role);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/searchRolePrivileges.do")
	public void searchPrivilegesList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int role = NumberUtils.toInt(request.getParameter("role"));
		Map<String, Object> map = PrivilegeServiceImpl.searchRolePrivilegesMap(role);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/saveRolePrivileges.do")
	public void saveRolePrivileges(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int role = NumberUtils.toInt(request.getParameter("role"));
		String priIds = request.getParameter("priIds");
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put(Constant.SUCCESS, PrivilegeServiceImpl.saveRolePrivileges(role,priIds));
		SchoaLogsServiceImpl.insertLogs(getSysUser(request),"设置角色权限，角色："+role+";权限："+priIds);
		response.getWriter().write(new Gson().toJson(map));
	}

	
}
