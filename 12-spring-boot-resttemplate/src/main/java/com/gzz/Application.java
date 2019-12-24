package com.gzz;

import javax.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@SpringBootApplication
public class Application {
	@Autowired
	private RestTemplate restTemplate;
	private static final Log logger = LogFactory.getLog(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

	@PostConstruct
	public void run() {
		
		String url = "http://gturnquist-quoters.cfapps.io/api/random";
//		String url = "http://localhost:8080/findById?id=1";
		String quote = restTemplate.getForObject(url, String.class);
		logger.info(quote);
	}
}
