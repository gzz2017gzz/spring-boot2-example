package com.gzz.aop;

import java.lang.annotation.*;

 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface NoRepeatSubmit {
    boolean removeToken() default false ;
}