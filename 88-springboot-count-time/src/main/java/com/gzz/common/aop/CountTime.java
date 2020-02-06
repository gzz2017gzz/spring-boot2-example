package com.gzz.common.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @类说明 [配合AOP统计时长的自定义注解类]
 * @author 高振中
 * @date 2019-11-26
 **/
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CountTime {
	String app() default "";// 当前应用名

	String method() default "";// 当前方法名

	Class<?> clazz();// 当前类
}
