package com.hao.schoa.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hao.schoa.tools.Constant;

/**
 * 权限拦截器
 * 
 * @author haoguowei
 * 
 */
public class PrivilegeInterceptorAdapter extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		
		String path = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf(".do"));
		path = path + ".do"; 
		if(Constant.allPrivilegeSet.contains(path)){
			//得到用户的权限url
			List<String> priList = (List<String>) request.getSession().getAttribute(Constant.SYS_MEMBER_PRI);
			if(priList.contains(path)){
				return true;
			}
		}else{
			return true;
		}
		response.sendRedirect(Constant.PRIVILEGES_URL); 
		return false;
	}

	/**
	 * This implementation is empty.
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * This implementation is empty.
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
