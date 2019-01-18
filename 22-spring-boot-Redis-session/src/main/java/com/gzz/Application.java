package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
//启动web应用后从地址栏测试
@EnableRedisHttpSession
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
