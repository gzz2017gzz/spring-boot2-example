springboot跨域有好多种方式 这里介几种 比较方便的几种写法

1.传统写法(单个方法用)
controller:
	@GetMapping(value = "count", produces = MediaType.APPLICATION_JSON_VALUE)
	public JSONPObject addBook(String callback) {
		return new JSONPObject(callback, new User());
	}
js:	
	$.ajax({
		url : "http://localhost:8080/api/count",
		dataType : "jsonp",
		success : function(data) {
			console.log(data)
		}
	});	
2. 全局配置(用到的可能性不大)

package com.gzz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfiguration implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
        .maxAge(3600)
        .allowCredentials(true);
	}
}

	$.ajax({
		url : "http://localhost:8080/api/count",
		success : function(data) {
			console.log(data)
		}
	});	
3. 注解方式最实用的@CrossOrigin(可以加在类上也可以加在方法上)

	@CrossOrigin 
	@RequestMapping("/hello")
	public Map<String, Object> hello() {
		Map<String, Object> map = new HashMap<>();
		map.put("hello", "你好");
		return map;
	}
 
$.ajax({
		url : "http://localhost:8080/hello",
		success : function(data) {
		console.log(data)
	}
});

4 使用nginx反代配置参见nginx目录 
	

/////测试方法
1.1 把template目录复制到桌面
1.2 用浏览器打开html才是正道
1.3 f12查看控制台 f5刷新
