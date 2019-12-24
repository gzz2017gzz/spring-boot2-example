package com.gzz.service;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
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
