package com.gzz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gzz.entity.User;
import com.gzz.service.UserService;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserService service;

//	@PostConstruct
	public void save() {
		User user = new User();
		user.setUserName("张四");
		user.setAge(80);
		user.setPassword("123456");
		service.save(user);
	}

	@PostConstruct
	public void select() {
		User user = service.findUserById(3);
		System.out.println(user);
	}

//	@PostConstruct
	public void update() {
		User user = new User();
		user.setId(1);
		user.setUserName("张三三");
		user.setAge(80);
		user.setPassword("123");
		service.edit(user);
	}

//	@PostConstruct
	public void delete() {
		service.delete(1);
	}
}
