package com.gzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class IndexController {

	@GetMapping("login_view")
	public String login_view() {
		return "login";
	}

	@GetMapping("index")
	public String index() {
		return "index";
	}
}
