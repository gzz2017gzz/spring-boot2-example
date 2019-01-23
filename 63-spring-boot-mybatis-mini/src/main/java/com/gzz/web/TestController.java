package com.gzz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.model.User;
import com.gzz.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserService userService;

	@RequestMapping("/add")
	public int add(@RequestBody User user) {
		return userService.add(user);
	}

}
