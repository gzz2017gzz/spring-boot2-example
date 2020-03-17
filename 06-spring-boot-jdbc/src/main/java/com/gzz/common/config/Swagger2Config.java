package com.gzz.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.apiInfo(new ApiInfoBuilder().title("XXXXX平台接口文档V1.0")//
						.description("彪悍的代码不需要注释！！！！")//
						.termsOfServiceUrl("https://www.jianshu.com/u/3bd57d5f1074")//
						.version("1.0").build())//
				.select().apis(RequestHandlerSelectors.basePackage("com.gzz"))//
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//
				.paths(PathSelectors.any()).build();//
	}
}
