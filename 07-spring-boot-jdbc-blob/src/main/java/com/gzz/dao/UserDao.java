package com.gzz.dao;

import java.sql.Types;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.stereotype.Repository;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Repository
public class UserDao {
	protected final Log logger = LogFactory.getLog(UserDao.class);
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	
	public void save() {
		String sql = "insert into base_user (id,name,remark) values(?,?,?)";
		Object[] params = { 1, "张三丰", new SqlLobValue("中华人民共和国".getBytes()) };
		jdbcTemplate.update(sql.toString(), params, new int[] { Types.INTEGER, Types.VARCHAR, Types.BLOB });
	}

	public void query() {
		String sql = "select * from base_user";
		List<BaseUser> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BaseUser.class));
		query.forEach(item -> {
			logger.info(item.getName());
			byte[] bytes = item.getRemark();
			logger.info(new String(bytes));
		});
		

	}

}