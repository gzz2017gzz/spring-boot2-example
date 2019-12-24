package com.gzz.webapp.sys.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.common.sys.user.User;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@RestController
@RequestMapping("user")
public class UserController {
	@RequestMapping("findById")
	public User findById(int id) {
		User user = new User();
		user.setName("张三");
		user.setPwd("12334456");
		return user;
	}
}
