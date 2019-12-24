package com.gzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@RestController
public class HelloController {
	@RequestMapping("/")
	public String index() {
		return "Hello Spring Boot 2.1.1!";
	}
}