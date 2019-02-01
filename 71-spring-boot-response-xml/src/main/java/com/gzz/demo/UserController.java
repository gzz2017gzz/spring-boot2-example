package com.gzz.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping(value = "/user", produces = MediaType.APPLICATION_XML_VALUE)
	public User create(User user) {
		user.setName("高振中");
		user.setAge(100);
		return user;
	}
}