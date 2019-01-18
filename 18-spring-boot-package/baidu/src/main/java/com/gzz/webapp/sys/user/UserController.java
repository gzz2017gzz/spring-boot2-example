package com.gzz.webapp.sys.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.common.sys.user.User;

@RestController
@RequestMapping("user")
public class UserController {
	@RequestMapping("queryList")
	public User findById(int id) {
		User user = new User();
		user.setName("张三");
		user.setPwd("12334456");
		return user;
	}
}
