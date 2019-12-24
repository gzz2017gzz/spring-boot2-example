package com.gzz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Repository
public class UserDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;// jdbc模版类

	public List<User> queryList() {
		String sql = "select * from sys_person";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	}

	public User findById(String id) {
		String sql = "select * from sys_person where id=?";
		String param[] = { id };
		return jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<>(User.class));
	}

}
