package com.gzz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
