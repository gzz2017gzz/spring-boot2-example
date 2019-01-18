package com.gzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gzz.rabbit.topic.TopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

	@Autowired
	private TopicSender sender;

//	@Test
	public void topic1() throws Exception {
		sender.send1();
	}

	@Test
	public void topic2() throws Exception {
		sender.send2();
	}

}