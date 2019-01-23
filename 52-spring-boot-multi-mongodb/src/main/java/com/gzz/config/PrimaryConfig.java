package com.gzz.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories(basePackages = "com.gzz.dao.primary", mongoTemplateRef = "primaryTemplate")
public class PrimaryConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.data.primary.mongodb")
	public MongoProperties primaryMongoProperties() {
		return new MongoProperties();
	}

	@Primary
	@Bean(name = "primaryTemplate")
	public MongoTemplate primaryMongoTemplate() throws Exception {
		return new MongoTemplate(primaryFactory(primaryMongoProperties()));
	}

	@Bean
	@Primary
	public MongoDbFactory primaryFactory(MongoProperties mongoProperties) {
		return new SimpleMongoDbFactory(new MongoClientURI(primaryMongoProperties().getUri()));
	}
}
