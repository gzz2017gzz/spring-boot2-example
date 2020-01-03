package com.gzz.sys.table;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Repository
@Slf4j
public class TableDao {

	/**
	 * @功能描述 系统变量及初始化
	 */

	@Value("${spring.datasource.url}")
	private String url;
	private String dbName;// 数据库名

	@PostConstruct
	private void init() {
		String[] split = url.split("[?]")[0].split("/");
		dbName = split[split.length - 1];
		log.info("当前数据库名称是:{}", dbName);
	}

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public List<Field> queryFields(String tableName) {
		StringBuilder sb = new StringBuilder();
		sb.append("	SELECT  column_name, column_comment, column_type, is_nullable,");
		sb.append("	IF (column_key = 'pri', '是', '')  pri ");
		sb.append("	FROM");
		sb.append("	information_schema.columns");
		sb.append("	WHERE table_schema = ? AND table_name = ?");
		return jdbcTemplate.query(sb.toString(), new Object[] { dbName, tableName }, new BeanPropertyRowMapper<>(Field.class));
	}

	public List<Table> queryTables() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT table_name  ,table_comment FROM information_schema.TABLES WHERE table_schema = ?");
		return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<>(Table.class), dbName);
	}
}
