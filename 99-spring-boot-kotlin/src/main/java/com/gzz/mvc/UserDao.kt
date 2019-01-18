package com.gzz.mvc


import org.springframework.stereotype.Repository

import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.gzz.base.BaseDao
import com.gzz.base.Page
import java.lang.StringBuffer

@Component
class UserDao : BaseDao() {
	fun queryList(cond: UserCond): List<User> {
		var sb: StringBuffer = StringBuffer();
		sb.append("select * from sys_user where 1=1 ")
		sb.append(cond.getCondition())
		return jdbcTemplate.query(sb.toString(), cond.getArray(), BeanPropertyRowMapper<User>(User::class.java))
	}

	fun queryPage(cond: UserCond): Page<User> {
		var sb: StringBuffer = StringBuffer();
		sb.append("select * from sys_user where 1=1 ")
		sb.append(cond.getCondition())
		return queryPage(sb.toString(), cond, User::class.java)
	}

	fun save(user: User): Int {
		var sql: String = "insert into sys_user (name,password,login_id) values (?,?,?)"
		var params = arrayOf<Any>(user.name, user.password, user.login_id);
		return jdbcTemplate.update(sql, params)
	}

	fun delete(id: Long): Int {
		var sql: String = "delete from sys_user where id=?"
		return jdbcTemplate.update(sql, arrayOf<Any>(id))
	}

	fun findById(id: Long): User {
		var sql: String = "select *  from sys_user where id=?"
		return jdbcTemplate.queryForObject(sql, arrayOf<Any>(id), BeanPropertyRowMapper<User>(User::class.java))
	}
}