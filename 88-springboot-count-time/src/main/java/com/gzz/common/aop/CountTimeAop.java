package com.gzz.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 [方法时长统计切面程序]
 * @author 高振中
 * @date 2019-11-26
 **/
@Slf4j
@Aspect
@Component
public class CountTimeAop {

	@Around("within(com.gzz..*) && @annotation(countTime) ")
	public Object ChangeRobotAops(ProceedingJoinPoint point, CountTime countTime) {
		Object proceed = null;
		String path = null;
		try {
			Long start = System.currentTimeMillis();
			proceed = point.proceed();// 调用目标方法
			path = countTime.clazz().getName() + "." + countTime.method();
			log.info("应用名:{},类名.方法名:{}(),耗时:{}毫秒", countTime.app(), path, System.currentTimeMillis() - start);
		} catch (Throwable e) {
			log.error("获取{" + path + "}方法消耗时长时发生异常！", e);
		}
		return proceed;
	}
}
