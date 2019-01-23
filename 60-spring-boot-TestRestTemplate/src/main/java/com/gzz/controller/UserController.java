package com.gzz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping("demo")
	public String demo1() {
		return "Hello-gzz";
	}
}
