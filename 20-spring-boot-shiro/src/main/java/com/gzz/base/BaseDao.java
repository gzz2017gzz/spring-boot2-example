package com.gzz.base;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@Scope("prototype")
public class BaseDao {
	protected final Log logger = LogFactory.getLog(BaseDao.class);
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Autowired
	protected NamedParameterJdbcTemplate nameJdbcTemplate;

	protected <T> Page<T> queryPage(String sql, BaseCondition cond, Class<T> clazz) {
		String countSQL = "SELECT count(1) FROM (" + sql + ") t";
		int rowCount = jdbcTemplate.queryForObject(countSQL, cond.getArray(), Integer.class);
		int pageSize = cond.getSize();
		int curPage = cond.getPage();
		int pageCount = rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
		String listSql = sql + " LIMIT " + curPage * pageSize + "," + pageSize;
		List<T> dataList = jdbcTemplate.query(listSql.toString(), cond.getArray(), new BeanPropertyRowMapper<T>(clazz));
		return new Page<T>(dataList, curPage, rowCount, pageSize, pageCount);
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

	/**
	 * @方法说明:用于批操作显示SQL
	 */
	public <T> String getField(Class<T> clazz) {
		StringBuilder sql = new StringBuilder();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			logger.info(field.getName());
			sql.append("t." + field.getName() + ",");
		}
		sql.deleteCharAt(sql.length() - 1);
		return sql.toString();
	}
}