package com.gzz.common.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author gzz_gzz@163.com
 */
@Configuration
public class DataSourceConfig {

	@Bean(name = "datasource1")
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "datasource2")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public DataSource getDataSource() {
		DynamicSource dds = new DynamicSource();
		dds.setDefaultTargetDataSource(dataSource1());
		Map<Object, Object> dsMap = new HashMap<>(5);
		dsMap.put("datasource1", dataSource1());
		dsMap.put("datasource2", dataSource2());
		dds.setTargetDataSources(dsMap);
		return dds;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(getDataSource());
	}

}
