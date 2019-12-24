package com.gzz.config;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;

import lombok.extern.slf4j.Slf4j;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Slf4j
@Component
@ConfigurationProperties("mysql")
public class DataSourceConfig {
	private List<DBmodel> dataSource;// 注入List

	@PostConstruct
	public void run() {
		log.info("dataSource={}", dataSource);
	}

	@Bean("dataSource1")
	public DataSource dataSource1() {
		DBmodel model = dataSource.get(0);
		MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
		mysqlXaDataSource.setUrl(model.getUrl());
		mysqlXaDataSource.setPassword(model.getPassword());
		mysqlXaDataSource.setUser(model.getUsername());
		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlXaDataSource);
		xaDataSource.setUniqueResourceName("dataSource1");
		return xaDataSource;
	}

	@Bean("dataSource2")
	public DataSource dataSource2() {
		DBmodel model = dataSource.get(1);
		MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
		mysqlXaDataSource.setUrl(model.getUrl());
		mysqlXaDataSource.setPassword(model.getPassword());
		mysqlXaDataSource.setUser(model.getUsername());
		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlXaDataSource);
		xaDataSource.setUniqueResourceName("dataSource2");
		return xaDataSource;
	}

	@Bean("jdbcTemplate1")
	public JdbcTemplate jdbcTemplate1(@Qualifier("dataSource1") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean("jdbcTemplate2")
	public JdbcTemplate jdbcTemplate2(@Qualifier("dataSource2") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	public List<DBmodel> getDataSource() {
		return dataSource;
	}

	public void setDataSource(List<DBmodel> dataSource) {
		this.dataSource = dataSource;
	}
}