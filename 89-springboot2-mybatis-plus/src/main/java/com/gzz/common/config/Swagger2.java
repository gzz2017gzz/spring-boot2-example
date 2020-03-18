package com.gzz.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.apiInfo(apiInfo())//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("com.gzz"))//
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))// 没有加注解的方法不显示
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))// 没有加注解的方法不显示
				.paths(PathSelectors.any())//
				.build();//
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("springboot利用swagger构建api文档")//
				.description("简单优雅的restfun风格，https://www.jianshu.com/u/3bd57d5f1074")//
				.termsOfServiceUrl("https://www.jianshu.com/u/3bd57d5f1074")//
				.version("1.0")//
				.build();//
	}
}
