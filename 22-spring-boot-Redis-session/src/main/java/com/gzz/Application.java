package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @说明 启动web应用后从地址栏测试
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@SpringBootApplication

@EnableRedisHttpSession
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
