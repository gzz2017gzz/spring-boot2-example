package com.gzz.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	protected final Log logger = LogFactory.getLog(UserDao.class);
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public void query1() {
		String sql = "select name from sys_user";
		List<String> names = jdbcTemplate.queryForList(sql, String.class);
		names.forEach(name -> logger.info(name));
	}

	public void query2() {
		String sql = "select name from sys_user";
		List<String> names = jdbcTemplate.query(sql, new SingleColumnRowMapper<>(String.class));
		names.forEach(name -> logger.info(name));
	}

	public void query3() {
		String sql = "select name from sys_user where id in(?,?,?,?,?,?)";
		Object[] params = { 1, 2, 3, 4, 5, 6 };
		List<String> names = jdbcTemplate.query(sql, new SingleColumnRowMapper<>(String.class), params);
		names.forEach(name -> logger.info(name));
	}
}