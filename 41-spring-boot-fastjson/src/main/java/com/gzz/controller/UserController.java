package com.gzz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("list")
	public List<User> list() {
		List<User> list = new ArrayList<>();
		list.add(new User(1, "gzz", 1));
		list.add(new User(2, "gzz", 1));
		User user = new User(3, "gzz", 1);
		list.add(user);
		list.add(user);
		return list;
	}

}
