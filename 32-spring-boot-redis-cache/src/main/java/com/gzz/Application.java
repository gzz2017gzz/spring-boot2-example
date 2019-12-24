package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@SpringBootApplication
@EnableCaching//开启缓存
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
