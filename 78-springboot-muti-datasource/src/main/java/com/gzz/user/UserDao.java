package com.gzz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	@Qualifier("jdbcTemplate1")
	private JdbcTemplate jdbcTemplate1;
	@Autowired
	@Qualifier("jdbcTemplate2")
	private JdbcTemplate jdbcTemplate2;

	public void save1(User user) {
		String sql = "insert into user values(null,?,?)";
		jdbcTemplate1.update(sql, user.getName(), user.getPassWord());
	}

	public void save2(User user) {
		String sql = "insert into user values(null,?,?)";
		jdbcTemplate2.update(sql, user.getName(), user.getPassWord());
	}
}
