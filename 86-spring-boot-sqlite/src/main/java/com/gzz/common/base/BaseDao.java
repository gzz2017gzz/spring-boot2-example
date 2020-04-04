package com.gzz.common.base;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import lombok.extern.slf4j.Slf4j;

/**
 * @功能描述 dao类公共类
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2020-02-02 02:20:20
 */
@Slf4j
@Scope("prototype")
public class BaseDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Autowired
	protected NamedParameterJdbcTemplate nameJdbcTemplate;

	/**
	 * @功能描述 分类查询
	 */
	final protected <T, C extends BaseCondition> Page<T> queryPage(final String sql, C cond, final Class<T> clazz) {
//		String countSQL = "SELECT count(1) FROM (" + sql + ") t";
		String countSQL = sql.replaceAll("(?i)(SELECT)(.*)(?i)(FROM)", "$1 count(1) $3");// 高效不支持嵌套
		log.debug(sql(countSQL, cond.array()));
		int rowCount = jdbcTemplate.queryForObject(countSQL, cond.array(), Integer.class);
		int pageSize = cond.getSize();
		int curPage = cond.getPage();
		int pageCount = rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
		StringBuffer listSQL = new StringBuffer();
		listSQL.append(sql);
		listSQL.append(" LIMIT ");
		listSQL.append(curPage * pageSize);
		listSQL.append(",");
		listSQL.append(pageSize);
		log.debug(sql(listSQL.toString(), cond.array()));
		List<T> dataList = jdbcTemplate.query(listSQL.toString(), cond.array(), new BeanPropertyRowMapper<T>(clazz));
		return new Page<T>(dataList, pageSize, rowCount, curPage, pageCount);
	}

	/**
	 * @功能描述 批操作
	 */
	final protected <T> int[] batchOperate(final List<T> list, final String sql) {
		return nameJdbcTemplate.batchUpdate(sql, list.stream().map(i -> new BeanPropertySqlParameterSource(i)).collect(Collectors.toList()).toArray(new BeanPropertySqlParameterSource[] {}));
	}

	/**
	 * @功能描述 保存数据返回主键
	 */
	final protected <T> int saveKey(final T t, String sql, final String id) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		nameJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(t), keyHolder, new String[] { id });
		return keyHolder.getKey().intValue();
	}

	/**
	 * @方法说明:数据库中执行的SQL语句
	 */
	final protected static String sql(String sql, final Object... object) {
		for (Object obj : object) {
			String param = "NOT FOUND PARAM!!";
			if (null != obj) {
				if (obj instanceof Date) {
					param = "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(obj) + "'";
				} else if (obj instanceof String) {
					param = "'" + (String) obj + "'";
				} else {
					param = obj.toString();
				}
			}
			sql = sql.replaceFirst("[?]", param);
		}
		return sql;
	}

	/**
	 * @方法说明 用于保存记录返回主键显示SQL(效率低用完关掉)
	 */
	final protected static <T> String sqlp(String sql, T t) {
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				Object value = field.get(t);
				sql = sql.replaceFirst(":" + field.getName(), value == null ? "null" : value.toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return sql;
	}

	/**
	 * @方法说明 用于批操作显示SQL(效率极低用完关掉)
	 */
	final protected static <T> String sqlp(String sql, List<T> list) {
		StringBuffer sb = new StringBuffer();
		for (T t : list) {
			sb.append(sqlp(sql, t) + "/r/n");
		}
		return sb.toString();
	}

	/**
	 * @方法说明 把组数拼接成(?,?,?)的形式
	 */
	final public static String toIn(final Object ids[]) {
		StringBuffer sb = new StringBuffer(" (?");
		for (int i = 1; i < ids.length; i++) {
			sb.append(",?");
		}
		sb.append(")");
		return sb.toString();
	}
}