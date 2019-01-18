package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Autowired
	private HttpSession session;

	@GetMapping("hello")
	public String hello() {
		return "hello redis!";
	}

	@GetMapping("put")
	public Map<String, Object> put() {
		Map<String, Object> map = new HashMap<>();
		String id = session.getId();
		map.put("sessionId", id);
		session.setAttribute("sessionId", id);
		return map;
	}

	@GetMapping("get")
	public Map<String, Object> get() {
		Map<String, Object> map = new HashMap<>();
		map.put("sessionId", session.getAttribute("sessionId"));
		return map;
	}
}
