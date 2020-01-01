package com.gzz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
	}
}
