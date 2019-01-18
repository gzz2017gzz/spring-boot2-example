package com.gzz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String register(User user) {
		userService.register(user);
		System.out.println("注册成功.");
		return "注册成功.";
	}
}
