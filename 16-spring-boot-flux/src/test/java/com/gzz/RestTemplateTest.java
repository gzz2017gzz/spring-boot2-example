package com.gzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
public class RestTemplateTest {
	@Test
	public void getHello() throws Exception {
		RestTemplateBuilder builder = new RestTemplateBuilder();
		RestTemplate restTemplate = builder.build();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		String url = "http://localhost:8080/findById?id=1";
		String response = restTemplate.getForObject(url, String.class);
		System.out.println(response);
	}
}