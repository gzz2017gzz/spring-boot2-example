
package com.gzz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Service
public class UserService {
	@Autowired
	private UserDao dao;

	@Transactional
	public void save(User user) {
		dao.save1(user);
		@SuppressWarnings("unused")
		int i = 1 / 0;
		System.out.println("数据库01插入完毕..");
		dao.save2(user);
	}

	public void save1(User user) {
		dao.save1(user);
	}

	public void save2(User user) {
		dao.save2(user);
	}
}
