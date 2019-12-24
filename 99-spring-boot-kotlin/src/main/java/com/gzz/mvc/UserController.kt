package com.gzz.mvc

import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import javax.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.RequestMapping
import com.gzz.mvc.User
import com.gzz.base.Page


@RestController
class UserController {

	@Autowired
	lateinit var service: UserService

	@RequestMapping("hello")
	fun page(): String {
		return "hello"
	}

	@RequestMapping("query")
	fun query(cond: UserCond): List<User> {
		return service.queryList(cond);
	}

	@RequestMapping("page")
	fun page(cond: UserCond): Page<User> {
		return service.queryPage(cond);
	}

}
