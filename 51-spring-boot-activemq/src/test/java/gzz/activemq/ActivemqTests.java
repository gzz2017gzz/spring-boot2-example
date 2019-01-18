package gzz.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gzz.activemq.Producer;
import com.gzz.activemq.Publisher;

/**
 * @author www.gaozz.club
 * @date 2018-08-26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqTests {

	@Autowired
	private Producer producer;

	@Autowired
	private Publisher publisher;

	//@Test
	public void contextLoads() {
		for (int i = 0; i < 10; i++) {
			producer.sendMsg("test.queue", "Queue Message " + i);
		}
	}

	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			publisher.publish("test.topic", "Topic Message " + i);
		}
	}
}
