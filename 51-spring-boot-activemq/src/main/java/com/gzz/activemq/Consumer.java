package com.gzz.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Service
public class Consumer {

	@JmsListener(destination = "test.queue")
	public void receiveMsg(String text) {
		System.out.println("<<==收到消息： " + text);
	}
}