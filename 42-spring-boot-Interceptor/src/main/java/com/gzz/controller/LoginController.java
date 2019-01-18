package com.gzz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class LoginController {

	@RequestMapping("login")
	public String login(HttpServletRequest request) {
		request.getSession().setAttribute("_session_user", new User(1, "gzz", 1));
		return "登录成功";
	}
}
