package com.gzz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@RestController
@RequestMapping("user")
public class LoginController {

	@RequestMapping("login")
	public String login(HttpServletRequest request) {
		request.getSession().setAttribute("_session_user", new User(1, "gzz", 1));
		return "登录成功";
	}
}
