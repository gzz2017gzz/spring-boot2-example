package com.gzz.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka消费者测试
 */
@Component
public class Consumer {

	@KafkaListener(topics = "test_topic")
	public void listen(ConsumerRecord<?, ?> record) throws Exception {
		System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
	}
}
