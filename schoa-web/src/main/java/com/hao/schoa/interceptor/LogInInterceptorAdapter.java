package com.hao.schoa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hao.schoa.tools.Constant;

/**
 * 登录拦截器
 * 
 * @author haoguowei
 * 
 */
public class LogInInterceptorAdapter extends HandlerInterceptorAdapter {
	
	private static final Logger logger = Logger.getLogger(LogInInterceptorAdapter.class);

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		String path = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf(".do"));
		if(path.equals("initLogin") || path.equals("login")){
			return true;
		}
		String loginName = (String) request.getSession(true).getAttribute(Constant.LONIN_NAME);
		if(loginName != null && StringUtils.isNotBlank(loginName.toString())){
			return true;
		}
		logger.error("Not Login!");
		response.sendRedirect(Constant.LONIN_URL); 
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
