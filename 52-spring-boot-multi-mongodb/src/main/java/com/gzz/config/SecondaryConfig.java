package com.gzz.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories(basePackages = "com.gzz.dao.secondary", mongoTemplateRef = "secondaryTemplate")
public class SecondaryConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.data.secondary.mongodb")
	public MongoProperties secondaryMongoProperties() {
		return new MongoProperties();
	}

	@Bean(name = "secondaryTemplate")
	public MongoTemplate secondaryMongoTemplate() throws Exception {
		return new MongoTemplate(secondaryFactory(secondaryMongoProperties()));
	}

	@Bean
	public MongoDbFactory secondaryFactory(MongoProperties mongoProperties) {
		return new SimpleMongoDbFactory(new MongoClientURI(secondaryMongoProperties().getUri()));
	}
}