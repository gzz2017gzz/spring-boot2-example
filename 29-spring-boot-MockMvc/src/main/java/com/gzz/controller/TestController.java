package com.gzz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("save")
	public User save(Integer id) {
		User user = new User();
		user.setName("李四");
		user.setId(id);
		return user;
	}

	@RequestMapping("update")
	public User update(User user) {
		return user;
	}

	@RequestMapping("insert")
	public User insert(@RequestBody User user) {
		return user;
	}

	@RequestMapping("select")
	public List<User> save(User user) {
		List<User> list = new ArrayList<>();
		list.add(user);
		return list;
	}
}
