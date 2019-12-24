package com.gzz.mvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.gzz.base.Page

@Service
class UserService {
	@Autowired
	lateinit var dao: UserDao

	fun queryList(cond: UserCond): List<User> {
		return dao.queryList(cond);
	}

	fun queryPage(cond: UserCond): Page<User> {
		return dao.queryPage(cond);
	}
}