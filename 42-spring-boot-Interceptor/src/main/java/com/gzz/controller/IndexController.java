package com.gzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
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
