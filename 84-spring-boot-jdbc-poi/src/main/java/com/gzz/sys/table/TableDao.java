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
public class TableDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public List<Field> queryFields(String tableName) {
		StringBuilder sb = new StringBuilder();
		sb.append("	SELECT  column_name, column_comment, column_type, is_nullable, IF (column_key = 'pri', '是', '')  pri ");
		sb.append("	FROM information_schema.columns WHERE table_name = ? AND table_schema = (SELECT DATABASE())");
		return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<>(Field.class), tableName);
	}

	public List<Table> queryTables() {
		String sql = "SELECT table_name,table_comment FROM information_schema.TABLES WHERE table_schema =(SELECT DATABASE())"
 				+ " and (table_name like 'bill_%' or table_name like 'budget_%')"
				+ " order by table_name";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Table.class));
	}
}
