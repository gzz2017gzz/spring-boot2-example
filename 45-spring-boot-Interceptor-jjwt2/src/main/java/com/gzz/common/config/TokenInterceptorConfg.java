package com.gzz.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Configuration
public class TokenInterceptorConfg implements WebMvcConfigurer {

	@Bean
	public TokenInterceptor TokenInterceptor() {
		return new TokenInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		List<String> skipList = Lists.newArrayList("/sysUser/login", "/sysUser/logout");// 跳过列表
		registry.addInterceptor(TokenInterceptor()).addPathPatterns("/**")
		.excludePathPatterns("/sysUser/login").excludePathPatterns("/sysUser/logout");
	}
}
