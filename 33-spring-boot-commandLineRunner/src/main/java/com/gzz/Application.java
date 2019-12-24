package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		System.out.println("The service to start.");
		SpringApplication.run(Application.class, args);
		System.out.println("The service has started.");
	}
}
