
package com.gzz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

 	@Transactional
	public void save(User user) {
		dao.save1(user);
//		@SuppressWarnings("unused")
//		int i = 1 / 0;
//		System.out.println("数据库01插入完毕..");
		dao.save2(user);
	}

	public void save1(User user) {
		dao.save1(user);
	}

	public void save2(User user) {
		dao.save2(user);
	}
}
