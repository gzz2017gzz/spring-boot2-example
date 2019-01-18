package com.gzz.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author www.gaozz.club
 * @date 2018-08-26
 */
@Service
public class Consumer {

	@JmsListener(destination = "test.queue")
	public void receiveMsg(String text) {
		System.out.println("<<==收到消息： " + text);
	}
}