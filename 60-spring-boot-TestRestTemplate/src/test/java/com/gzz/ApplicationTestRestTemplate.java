package com.gzz;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTestRestTemplate {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;

	@Test
	public void demo1() throws Exception {
		URL base = new URL("http://localhost:" + port + "/gzz/demo");
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertEquals(response.getBody(), "Hello-gzz");
	}
}
