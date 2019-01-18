package com.gzz.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author www.gaozz.club
 * @date 2018-08-26
 */
@Service
public class Subscriber {

	@JmsListener(destination = "test.topic", containerFactory = "myJmsContainerFactory")
	public void subscribe(String text) {
		System.out.println("<<==收到订阅的消息" + text);
	}
}
