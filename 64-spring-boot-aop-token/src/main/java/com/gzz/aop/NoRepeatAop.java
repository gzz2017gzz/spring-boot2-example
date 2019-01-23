package com.gzz.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NoRepeatAop {
	@Autowired
	private HttpServletRequest request;
	private static final Logger logger = LoggerFactory.getLogger(NoRepeatAop.class);

	@Before("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(noRepeat)")
	public void testToken(final JoinPoint joinPoint, NoRepeatSubmit noRepeat) {
		if (noRepeat != null && noRepeat.removeToken()) {
			String serverToken = (String) request.getSession().getAttribute("token");
			if (serverToken == null) {
				logger.info("原token为空,不通过!");
				return;
			}
			String clinetToken = request.getParameter("token");
			if (clinetToken == null || clinetToken.equals("")) {
				logger.info("客户端token为空,不通过!");
				return;
			}
			if (!serverToken.equals(clinetToken)) {
				logger.info("原token与客户端token不等,不通过!");
				return;
			}
			logger.info("校验是否重复提交：表单页面Token值为：" + clinetToken + ",Session中的Token值为:" + serverToken);
			request.getSession().removeAttribute("token");

		} 
	}
}
