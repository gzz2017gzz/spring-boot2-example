package com.gzz.user;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.gzz.common.base.BaseDao;
import com.gzz.common.config.ChangeDataSource;
import com.gzz.user.model.User;
import com.gzz.user.model.UserCond;

/**
 * @功能描述:数据访问类
 * @author gzz_gzz@163.com
 * @date 2018-03-08
 */
@Repository
public class UserDao extends BaseDao {

	@ChangeDataSource("datasource1")
	public List<User> queryDs1(UserCond cond) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * from user WHERE 1=1");
		sb.append(cond.getCondition());
//		logger.info(SqlUtil.showSql(sb.toString(), cond.getArray()));
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(User.class));
	}

	@ChangeDataSource("datasource2")
	public List<User> queryDs2(UserCond cond) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * from user WHERE 1=1");
		sb.append(cond.getCondition());
//		logger.info(SqlUtil.showSql(sb.toString(), cond.getArray()));
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(User.class));
	}

}
