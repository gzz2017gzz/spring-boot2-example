package com.gzz.common.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Aspect
@Component
public class DataSourceAop {
	@Around("within(com..*) && @annotation(db)")
	public Object doBasicProfiling(ProceedingJoinPoint pjp, ChangeDataSource db) {
		DynamicSource.setDB(db.value());
		Object object = null;
		try {
			object = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			DynamicSource.setDefalt();
		}
		DynamicSource.setDefalt();
		return object;
	}

}