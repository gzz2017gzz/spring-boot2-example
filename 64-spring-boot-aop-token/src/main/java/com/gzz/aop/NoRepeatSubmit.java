package com.gzz.aop;

import java.lang.annotation.*;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface NoRepeatSubmit {
    boolean removeToken() default false ;
}