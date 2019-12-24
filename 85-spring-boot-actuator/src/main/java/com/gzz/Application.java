package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import com.gzz.endpoint.MyEndPoint;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	static class MyEndpointConfiguration {
		@Bean
		@ConditionalOnMissingBean
		@ConditionalOnEnabledEndpoint
		public MyEndPoint myEndPoint() {
			return new MyEndPoint();
		}
	}

}