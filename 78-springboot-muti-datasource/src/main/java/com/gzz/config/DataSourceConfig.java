package com.gzz.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Component
public class DataSourceConfig {
	@Bean("dataSource1")
	@ConfigurationProperties("mysql.datasource1")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	@Bean("dataSource2")
	@ConfigurationProperties("mysql.datasource2")
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}

	@Bean("jdbcTemplate1")
	public JdbcTemplate jdbcTemplate1(@Qualifier("dataSource1") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean("jdbcTemplate2")
	public JdbcTemplate jdbcTemplate2(@Qualifier("dataSource2") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}