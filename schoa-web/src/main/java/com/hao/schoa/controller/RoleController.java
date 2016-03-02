package com.hao.schoa.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.service.RoleServiceImpl;

/**
 * 角色管理
 * @author haoguowei
 *
 */
@Controller
public class RoleController {

	@RequestMapping("/initRole.do")
	public String initRole(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "manager/role";
	}
	
	@RequestMapping("/searchRoles.do")
	public void searchRoles(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = RoleServiceImpl.search();
		response.getWriter().write(new Gson().toJson(map));
	}
}
