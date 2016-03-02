package com.hao.schoa.controller;

import java.io.IOException;
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
import com.hao.schoa.po.Member;
import com.hao.schoa.po.MemberPeer;
import com.hao.schoa.po.Role;
import com.hao.schoa.po.Teacher;
import com.hao.schoa.service.MemberServiceImpl;
import com.hao.schoa.service.RoleServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.TeacherServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.Md5Util;

@Controller
public class MemberController extends BaseSchoa{

	@RequestMapping("/initMemberManager.do")
	public String initMemberManager(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		return "manager/member";
	}
	
	@RequestMapping("/initEditMember.do")
	public String initEditMember(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Member member = MemberServiceImpl.getById(id);
		
		List<Role> roleList = RoleServiceImpl.getRoleList();
		request.setAttribute("roles", roleList);
		
		List<Teacher> teachers = TeacherServiceImpl.searchTeachersAsList();
		request.setAttribute("teachers", teachers);
		
		request.setAttribute("member", member);
		return "manager/memberEdit";
	}
	@RequestMapping("/initEditMemberPWD.do")
	public String initEditMemberPWD(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int id = NumberUtils.toInt(request.getParameter("id"));
		Member member = MemberServiceImpl.getById(id);
		
		request.setAttribute("member", member);
		return "manager/memberEditPWD";
	}
	
	@RequestMapping("/searchMembers.do")
	public void searchMembers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int start = NumberUtils.toInt(request.getParameter("start"));
		int limit = NumberUtils.toInt(request.getParameter("limit"), Constant.LIMIT);
		
		Map<String, Object> map = MemberServiceImpl.search(start, limit);
		response.getWriter().write(new Gson().toJson(map));
	}
	
	@RequestMapping("/saveMember.do")
	public String saveClasses(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		int roleId = NumberUtils.toInt(request.getParameter("roleId"));
		String showName = request.getParameter("showName");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		int teacherId = NumberUtils.toInt(request.getParameter("teacherId"));
		
		try {
			if(id == 0){
				//新注册用户
				Member tmp = MemberServiceImpl.getMemberByName(name);
				if(tmp != null){
					setErrorAttribute(request, "用户\""+name+"\"已被注册，请选用其他登录名！");
					return FAIL;
				}
				
				Member member = new Member();
				member.setName(name);
				member.setShowName(showName);
				member.setPhone(phone);
				member.setEmail(email);
				member.setPwd(Md5Util.getMD5String(pwd));
				member.setRoleId(roleId);
				member.setTeacherId(teacherId);
				MemberPeer.doInsert(member);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"添加系统用户:"+member.toString());
			}else{
				//修改用户信息
				Member member = MemberServiceImpl.getById(id);
				member.setShowName(showName);
				member.setPhone(phone);
				member.setEmail(email);
				member.setRoleId(roleId);
				member.setTeacherId(teacherId);
				MemberPeer.doUpdate(member);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改系统用户:"+member.toString());
			}
			
			return setSuccessAttribute(request, "用户管理", "initMemberManager.do");
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	@RequestMapping("/saveMemberPwd.do")
	public String saveMemberPwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("hideId"));
		String oldpwd = request.getParameter("oldpwd");
		String pwd = request.getParameter("pwd");
		
		try {
			Member member = MemberServiceImpl.getById(id);
			
			String oldpwdMd5 = Md5Util.getMD5String(oldpwd);
			String pwdMd5 = Md5Util.getMD5String(pwd);
			
			if(member != null && !member.getPwd().equals(oldpwdMd5)){
				setErrorAttribute(request, "旧密码验证失败！");
				return FAIL;
			}
			if(member != null && member.getPwd().equals(oldpwdMd5)){
				member.setPwd(pwdMd5);
				MemberPeer.doUpdate(member);
				SchoaLogsServiceImpl.insertLogs(getSysUser(request),"修改用户密码:"+member.toString());
				return setSuccessAttribute(request, "用户管理", "initMemberManager.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
		}
		return FAIL;
	}
	
	@RequestMapping("/initEditMemberValid.do")
	public void initEditMemberValid(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		int id = NumberUtils.toInt(request.getParameter("id"));
		int value = NumberUtils.toInt(request.getParameter("value"));
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		map.put(Constant.SUCCESS, false);
		try {
			String sql = "update " + MemberPeer.TABLE_NAME 
						+ " set " + MemberPeer.VALID + " = " + value 
						+ " where " + MemberPeer.ID + "=" + id;
			MemberPeer.executeStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(Constant.SUCCESS, true);
		response.getWriter().write(new Gson().toJson(map));
	}
}
