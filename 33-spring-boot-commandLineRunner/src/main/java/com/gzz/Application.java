package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		System.out.println("The service to start.");
		SpringApplication.run(Application.class, args);
		System.out.println("The service has started.");
	}
}
