package com.gzz.service;

import java.util.List;

import com.gzz.model.User;
import com.gzz.model.UserCondition;

public interface IUserService {
	String findById(long id);

	List<User> queryList(UserCondition cond);
}
