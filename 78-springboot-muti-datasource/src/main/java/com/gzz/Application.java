package com.gzz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.gzz.user.User;
import com.gzz.user.UserService;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
	@Autowired
	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

 	@PostConstruct
	public void run() {
		User user = User.builder().name("张三").passWord("123456").build();
		service.save1(user);
	}
}
