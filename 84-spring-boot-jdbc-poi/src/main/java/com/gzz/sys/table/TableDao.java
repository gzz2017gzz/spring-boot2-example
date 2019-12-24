package com.gzz.sys.table;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Repository
public class TableDao  {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	public List<Field> queryFields(String tableName) {
		StringBuilder sb = new StringBuilder();
		sb.append("	SELECT  column_name, column_comment, column_type, is_nullable,");
		sb.append("	IF (column_key = 'pri', '是', '')  pri ");
		sb.append("	FROM");
		sb.append("	information_schema.columns");
		sb.append("	WHERE table_schema = 'robottest' AND table_name = ?");
		return jdbcTemplate.query(sb.toString(), new Object[] { tableName }, new BeanPropertyRowMapper<>(Field.class));
	}

	public List<Table> queryTables() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT table_name  ,table_comment FROM information_schema.TABLES WHERE table_schema = 'robottest'");
		return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<>(Table.class));
	}
}
