package com.gzz.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Service
public class Subscriber {

	@JmsListener(destination = "test.topic", containerFactory = "myJmsContainerFactory")
	public void subscribe(String text) {
		System.out.println("<<==收到订阅的消息" + text);
	}
}
