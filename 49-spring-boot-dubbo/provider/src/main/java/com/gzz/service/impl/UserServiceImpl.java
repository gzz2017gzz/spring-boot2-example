package com.gzz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.gzz.model.User;
import com.gzz.model.UserCondition;
import com.gzz.service.IUserService;

@Service(interfaceClass = IUserService.class)
@Component
public class UserServiceImpl implements IUserService {

	@Override
	public String findById(long id) {
		return "hello" + id;
	}

	@Override
	public List<User> queryList(UserCondition cond) {
		System.out.println(cond.getId());
		List<User> users = new ArrayList<>();
		users.add(new User(1, "张三", (short) 10));
		users.add(new User(2, "李四", (short) 11));
		users.add(new User(3, "王五", (short) 12));
		users.add(new User(4, "张三丰", (short) 13));
		return users;
	}

}
