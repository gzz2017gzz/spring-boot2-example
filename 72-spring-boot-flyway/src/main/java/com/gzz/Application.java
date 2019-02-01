package com.gzz;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gzz.config.DataSourceVo;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@ConfigurationProperties
public class Application {
	private Log logger = LogFactory.getLog(getClass());
	private String dirver = "com.mysql.cj.jdbc.Driver";
	private Map<String, DataSourceVo> datasource;
	@PostConstruct
	public void init() {
		logger.info(datasource);
		datasource.forEach((k, v) -> exec(k, v));
	}
	public void exec(String dbname, DataSourceVo vo) {
		DataSource ds = DataSourceBuilder.create().driverClassName(dirver).url(vo.getUrl().replace(dbname, "mysql"))
				.username(vo.getUser()).password(vo.getPassword()).build();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		int count = jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name='" + dbname + "'", Integer.class);
		if (count == 0) {
			jdbcTemplate.execute("DROP DATABASE IF EXISTS " + dbname);
			jdbcTemplate.execute("CREATE DATABASE " + dbname + " DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci");
			logger.info("创建数据库[" + dbname + "]完成!!");
		}
		DataSource dataSource = DataSourceBuilder.create().driverClassName(dirver).url(vo.getUrl())
				.username(vo.getUser()).password(vo.getPassword()).build();

		FluentConfiguration configure = Flyway.configure();
		configure.dataSource(dataSource);
		configure.locations(dbname);
		Flyway flyway = new Flyway(configure);
		flyway.migrate();

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public Map<String, DataSourceVo> getDatasource() {
		return datasource;
	}

	public void setDatasource(Map<String, DataSourceVo> datasource) {
		this.datasource = datasource;
	}

}
