package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@RestController
@RequestMapping("api")
public class UserController {
	// ajax jsonp 访问
	@GetMapping(value = "count", produces = MediaType.APPLICATION_JSON_VALUE)
	public JSONPObject addBook(String callback) {
		return new JSONPObject(callback, new User());
	}

	// ngix 代理访问(普通方法)
	@GetMapping("save")
	public User save(String callback) {
		return new User();
	}

	@CrossOrigin
	@RequestMapping("/hello")
	public Map<String, Object> hello() {
		Map<String, Object> map = new HashMap<>();
		map.put("hello", "你好");
		// $.ajax({
		// url : "http://localhost:8080/hello",
		// success : function(data) {
		// console.log(data)
		// }
		// });
		return map;
	}
}
