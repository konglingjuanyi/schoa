package com.hao.schoa.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hao.schoa.BaseSchoa;
import com.hao.schoa.container.TreeNodeMode;
import com.hao.schoa.po.Member;
import com.hao.schoa.service.MemberServiceImpl;
import com.hao.schoa.service.PrivilegeServiceImpl;
import com.hao.schoa.service.SchoaLogsServiceImpl;
import com.hao.schoa.service.SystemServiceImpl;
import com.hao.schoa.service.TeacherServiceImpl;
import com.hao.schoa.tools.Constant;
import com.hao.schoa.tools.Md5Util;


@Controller
public class SystemController extends BaseSchoa{
	
	@RequestMapping("/getSysMenuTree.do")
	public void getSysMenuTree(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//得到用户的权限url
		List<String> priList = (List<String>) request.getSession().getAttribute(Constant.SYS_MEMBER_PRI);
		//得到所有目录树数据
		List<TreeNodeMode> all = SystemServiceImpl.getMenuTree();
		//只要有权限的节点
		List<TreeNodeMode> result = new ArrayList<TreeNodeMode>();
		for(TreeNodeMode node : all){
			if(!node.isLeaf()){
				List<TreeNodeMode> childs = node.getChildren();
				List<TreeNodeMode> newChilds = new ArrayList<TreeNodeMode>();
				for(TreeNodeMode tmp : childs){
					if(priList.contains(tmp.getHref())){
						newChilds.add(tmp);
					}
				}
				if(newChilds.size() > 0){
					node.setChildren(newChilds);
					result.add(node);
				}
			}else{
				if(priList.contains(node.getHref())){
					result.add(node);
				}
			}
		}
		response.getWriter().write(new Gson().toJson(result));
	}
	
	@RequestMapping("/initMain.do")
	public String initMain(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return "main";
	}
	
	@RequestMapping("/quitSystem.do")
	public String quitSystem(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.getSession().setAttribute(Constant.LONIN_NAME,null);
		request.getSession().setAttribute(Constant.LONIN_SHOWNAME,null);
		request.getSession().setAttribute(Constant.SYS_MEMBER_LOGIN, null);
		request.getSession().setAttribute(Constant.SYS_MEMBER_PRI, null);
		return "login";
	}
	
	@RequestMapping("/initLogin.do")
	public String initLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return "login";
	}
	
	@RequestMapping("/initNoPrivileges.do")
	public String initNoPrivileges(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return NOPRIVILEGES;
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String username = request.getParameter("loginName");
		String pwd = request.getParameter("loginPwd");
		
		Member member = MemberServiceImpl.getMemberByName(username);
		
		if(member != null && member.getValid() == 0 && member.getPwd().equals(Md5Util.getMD5String(pwd))){
			if(member.getTeacherId() > 0){
				member.setTeacher(TeacherServiceImpl.getById(member.getTeacherId()));
			}
			
			request.getSession().setAttribute(Constant.LONIN_NAME, member.getName());
			request.getSession().setAttribute(Constant.LONIN_SHOWNAME, member.getShowName());
			request.getSession().setAttribute(Constant.SYS_MEMBER_LOGIN, member);
			request.getSession().setAttribute(Constant.SYS_MEMBER_PRI, PrivilegeServiceImpl.getPrivileges(member.getRoleId()));
			SchoaLogsServiceImpl.insertLogs(getSysUser(request),"用户登录");
			response.sendRedirect(Constant.MAIN_URL);
			return null;
		}else{
			request.setAttribute("info", "用户名或密码错误！");
			return "login";
		}
	}
	
	/**
	 * 执行sql语句页面
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/initsql.do")
	public String initSQL(HttpServletRequest request,HttpServletResponse response) throws IOException {
		if(!isAdminPrivilege(request)){
			return NOPRIVILEGES;
		}
		return "sql";
	}
	
	/**
	 * 执行sql语句
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/exesql.do")
	public String exeSQL(HttpServletRequest request,HttpServletResponse response) throws IOException {
		if(!isAdminPrivilege(request)){
			return NOPRIVILEGES;
		}
		
		String sqls = request.getParameter("sqls");
		if(StringUtils.isBlank(sqls)){
			setErrorAttribute(request, "SQL 语句为空！");
			return FAIL;
		}
		
		String[] arr = sqls.split(";");
		Connection con = null;
		
		try {
			con = Transaction.begin();
			for(int i = 0 ; i < arr.length ; i++){
				String sql = arr[i];
				if(StringUtils.isBlank(sql)){
					continue;
				}
				sql = sql.trim();
				System.out.println("要执行的SQL == > " + sql);
				
				BasePeer.executeStatement(sql, con);
			}
			Transaction.commit(con);
			return setSuccessAttribute(request, "执行SQL", "initsql.do");
		} catch (Exception e) {
			Transaction.safeRollback(con);
			e.printStackTrace();
			setErrorAttribute(request, e.getMessage());
			return FAIL;
		}finally{
			con = null;
		}
	}
	
}
