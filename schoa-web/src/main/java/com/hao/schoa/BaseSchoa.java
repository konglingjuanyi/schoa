package com.hao.schoa;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.hao.schoa.po.Member;
import com.hao.schoa.tools.Constant;

public class BaseSchoa {
	
	public static final String MODELDIR = "/reportModel/";
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	public static final String NOPRIVILEGES = "noPrivileges";
	
	public static final String manager = "manager/";
	public static final String teaching = "teaching/";
	public static final String question = "question/";

	/**
	 * 得到登录用户名
	 * @param request
	 * @return
	 */
	public String getSysUser(HttpServletRequest request){
		return (String) request.getSession().getAttribute(Constant.LONIN_NAME);
	}
	
	/**
	 * 得到登录用户
	 * @param request
	 * @return
	 */
	public Member getSysMember(HttpServletRequest request){
		return (Member) request.getSession().getAttribute(Constant.SYS_MEMBER_LOGIN);
	}
	
	/**
	 * 是否是管理员权限
	 * @param roleId
	 * @return
	 */
	public boolean isAdminRole(int roleId){
		return roleId == 1;
	}
	
	/**
	 * 判断教师权限
	 * @param request
	 * @param teacherId
	 * @return
	 */
	public boolean isTeacherPrivilege(HttpServletRequest request, int teacherId){
		Member member = getSysMember(request);
		if(member == null || teacherId <= 0){
			return false;
		}
		if(isAdminRole(member.getRoleId()) || member.getTeacherId() == teacherId){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断管理员权限
	 * @param request
	 * @return
	 */
	public boolean isAdminPrivilege(HttpServletRequest request){
		Member member = getSysMember(request);
		if(member == null){
			return false;
		}
		if(isAdminRole(member.getRoleId())){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断管理员权限
	 * @param member
	 * @return
	 */
	public boolean isAdminPrivilege(Member member){
		if(member == null){
			return false;
		}
		if(isAdminRole(member.getRoleId())){
			return true;
		}
		return false;
	}
	
	/**
	 * 输出提示
	 * @param request
	 * @param msg
	 */
	public void setErrorAttribute(HttpServletRequest request, String msg){
		request.setAttribute("msg", msg);
	}
	
	
	/**
	 * 成功后返回提示
	 * @param request
	 * @param url
	 * @param title
	 * @return
	 */
	public String setSuccessAttribute(HttpServletRequest request, String title, String url){
		if(StringUtils.isNotBlank(title)){
			request.setAttribute("title", title);
		}
		if(StringUtils.isNotBlank(url)){
			request.setAttribute("url", url);
		}
		return SUCCESS;
	}
	
	/**
	 * 得到系统路径
	 * @param request
	 * @return
	 */
	public String getRealPath(HttpServletRequest request){
		return request.getServletContext().getRealPath("");
	}
	
	/**
	 * 得到模版文件夹路径
	 * @param request
	 * @return
	 */
	public String getModelFilePath(HttpServletRequest request){
		return getRealPath(request) + MODELDIR;
	}
	
	/**
	 * 导出excel文件名转码
	 * @param fname
	 * @return
	 */
	public static String getExportFileName(String fname){
		try {
			return new String(fname.getBytes("GB2312"),"ISO8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return fname;
	}
	
	/**
	 * 返回教师绩效管理相关页面
	 * @param page
	 * @return
	 */
	public String teachingJSP(String page){
		return teaching + page;
	}
	
	/**
	 * 返回题库管理相关页面
	 * @param page
	 * @return
	 */
	public String questionJSP(String page){
		return question + page;
	}
	
	/**
	 * 返回manager相关页面
	 * @param page
	 * @return
	 */
	public String managerJSP(String page){
		return manager + page;
	}
}
