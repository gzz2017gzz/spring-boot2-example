package com.gzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.dao.UserDao;
import com.gzz.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public int add(User user) {
		return dao.insertUser(user);
	}
}
