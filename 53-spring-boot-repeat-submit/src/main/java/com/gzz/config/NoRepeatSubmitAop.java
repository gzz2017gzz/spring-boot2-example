package com.gzz.config;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
/**
 * @功能描述 aop解析注解
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public class NoRepeatSubmitAop {

	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private RedisTemplate<String, Integer> template;

	@Around("execution(* com.example..*Controller.*(..)) && @annotation(nrs)")
	public Object arround(ProceedingJoinPoint pjp, NoRepeatSubmit nrs) {
		ValueOperations<String, Integer> opsForValue = template.opsForValue();
		try {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
			HttpServletRequest request = attributes.getRequest();
			String key = sessionId + "-" + request.getServletPath();
			if (opsForValue.get(key) == null) {// 如果缓存中有这个url视为重复提交
				Object o = pjp.proceed();
				opsForValue.set(key, 0, 2, TimeUnit.SECONDS);
				return o;
			} else {
				logger.error("重复提交");
				return null;
			}
		} catch (Throwable e) {
			e.printStackTrace();
			logger.error("验证重复提交时出现未知异常!");
			return "{\"code\":-889,\"message\":\"验证重复提交时出现未知异常!\"}";
		}

	}

}
