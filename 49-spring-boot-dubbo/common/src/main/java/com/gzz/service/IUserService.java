package com.gzz.service;

import java.util.List;

import com.gzz.model.User;
import com.gzz.model.UserCondition;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public interface IUserService {
	String findById(long id);

	List<User> queryList(UserCondition cond);
}
