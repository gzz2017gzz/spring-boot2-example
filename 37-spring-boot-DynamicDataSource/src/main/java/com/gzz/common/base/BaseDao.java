package com.gzz.common.base;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 * @功能描述:dao类公共类
 * @author gzz_gzz@163.com
 * @date 2018-02-15
 */
public class BaseDao {
	protected final Log logger = LogFactory.getLog(BaseDao.class);// 日志类
	@Autowired
	protected JdbcTemplate jdbcTemplate;// jdbc模版类
	@Autowired
	protected NamedParameterJdbcTemplate nameJdbcTemplate;// jdbc模版类

	protected <T> Page<T> queryPage(String sql, BaseCondition cond, Class<T> clazz) {
		String countSQL = "SELECT count(1) FROM (" + sql + ") t";// 统计记录个数的SQL语句
		int rowCount = jdbcTemplate.queryForObject(countSQL, cond.getArray(), Integer.class);// 查询记录个数
		cond.setRowCount(rowCount);
		int pageSize = cond.getSize();// 页大小
		int curPage = cond.getPage();// 当前页
//		cond.setPageCount(rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1);// 页数
		String listSql = sql + " LIMIT " + curPage * pageSize + "," + pageSize;// 查询分页数据列表的SQL语句
		List<T> dataList = jdbcTemplate.query(listSql.toString(), cond.getArray(), new BeanPropertyRowMapper<T>(clazz));
		return new Page<T>(dataList, cond.getPage(), cond.getSize(), cond.getRowCount());
	}

	protected <T> int[] batchOperate(List<T> list, String sql) {
		SqlParameterSource[] params = new SqlParameterSource[list.size()];
		for (int i = 0; i < list.size(); i++) {
			params[i] = new BeanPropertySqlParameterSource(list.get(i));
		}
		return nameJdbcTemplate.batchUpdate(sql, params);
	}

	protected <T> long saveKey(T t, String sql, String id) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource params = new BeanPropertySqlParameterSource(t);
		nameJdbcTemplate.update(sql, params, keyHolder, new String[] { id });
		return keyHolder.getKey().longValue();
	}

}