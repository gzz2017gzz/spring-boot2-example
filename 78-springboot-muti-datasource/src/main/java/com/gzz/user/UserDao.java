package com.gzz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
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
