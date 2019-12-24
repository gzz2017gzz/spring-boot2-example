package com.gzz.web;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@RestController
public class HomeController {

	@GetMapping("/hello")
	public Map<String, Object> greeting() {
		return Collections.singletonMap("message", "Hello World");
	}

	@PostMapping("/world")
	public Map<String, Object> hello() {
		return Collections.singletonMap("world", "Hello World");
	}

}