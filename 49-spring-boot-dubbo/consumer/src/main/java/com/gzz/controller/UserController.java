package com.gzz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gzz.model.User;
import com.gzz.model.UserCondition;
import com.gzz.service.IUserService;

@RestController
public class UserController {
	@Reference
	private IUserService service;

	@GetMapping("hello/{id}")
	public String get(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping("query")
	public List<User> query(UserCondition cond) {
		return service.queryList(cond);
	}
}
