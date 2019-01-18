package com.gzz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	@GetMapping("query")
	public String queryUser(ModelMap map) {
		List<String> users = new ArrayList<String>();
		users.add("admin");
		users.add("user1");
		users.add("user2");
		map.put("users", users);
		log.info("来吧");
		return "index";
	}

}
