package com.gzz.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		System.out.println(request.getRequestURI());
		// 登录不做拦截
		if (request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")) {
			System.out.println("登录不做拦截");
			return true;
		}
		// 验证session是否存在
		Object obj = request.getSession().getAttribute("_session_user");
		if (obj == null) {
			System.out.println("_session_user不存在");
			response.sendRedirect("/user/login_view");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
