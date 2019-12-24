package com.gzz.common.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzz.study.sys.syslog.SysLog;
import com.gzz.study.sys.syslog.SysLogService;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
public class LogInterceptor implements HandlerInterceptor {
	@Autowired
	private SysLogService service;

	// 请求日志实体标识
	private static final String LOGGER_ENTITY = "_logger_entity";
	public static final String LOGGER_RETURN = "_logger_return";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		SysLog logger = new SysLog();// 创建日志实体

		String paramData = new ObjectMapper().writeValueAsString(request.getParameterMap());
		logger.setClient_ip(IPUtils.getCliectIp(request));// 客户端ip
		logger.setMethod(request.getMethod());// 请求方法
		logger.setType(request.getHeader("Content-Type")); // 请求类型
		logger.setParam_data(paramData);// 请求参数内容json字符串
		logger.setUri(request.getRequestURI()); // 请求地址
		logger.setSession_id(request.getSession().getId());// sessionId
		logger.setRequest_time(System.currentTimeMillis());// 请求开始时间

		request.setAttribute(LOGGER_ENTITY, logger);// 设置请求实体到request内，方面afterCompletion方法调用
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
		long currentTime = System.currentTimeMillis();
		SysLog logger = (SysLog) request.getAttribute(LOGGER_ENTITY);// 获取本次请求日志实体
		logger.setCost_time(Integer.valueOf((currentTime - logger.getRequest_time()) + "")); // 设置请求时间差
		logger.setReturn_time(currentTime);// 设置返回时间
		logger.setStatus_code(response.getStatus());// 请求状态码
		logger.setReturn_data(new ObjectMapper().writeValueAsString(request.getAttribute(LOGGER_RETURN)));
		service.save(logger); // 执行将日志写入数据库
	}
}
