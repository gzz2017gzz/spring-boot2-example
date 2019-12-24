package test.com.goku.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.gzz.DemoApplication;
import com.gzz.dao.primary.UserDaoPrimary;
import com.gzz.dao.secondary.UserDaoSecondary;
import com.gzz.model.User;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class UserDaoTest {
	@Autowired
	private UserDaoPrimary daoPrimary;
	@Autowired
	private UserDaoSecondary daoSecondary;

	@Before
	public void setUp() {
		daoPrimary.deleteAll();
	}

	@Test
	public void test() throws Exception {
		// 创建三个User，并验证User总数
		daoPrimary.save(new User(1L, "didi", 30));
		daoPrimary.save(new User(2L, "mama", 40));
		daoPrimary.save(new User(3L, "kaka", 50));
		log.info(String.valueOf(daoPrimary.findAll().size()));

		// 删除一个User，再验证User总数
		User u = daoPrimary.findById(1L).get();
		log.info(u.toString());
		daoPrimary.delete(u);
		log.info(String.valueOf(daoPrimary.findAll().size()));

		// 删除一个User，再验证User总数
		u = daoPrimary.findByUsername("mama");
		log.info(u.toString());
		daoPrimary.delete(u);
		log.info(String.valueOf(daoPrimary.findAll().size()));
	}

	@Test
	public void test2() throws Exception {
		// 创建三个User，并验证User总数
		daoSecondary.save(new User(1L, "didi22", 30));
		daoSecondary.save(new User(2L, "mama22", 40));
		daoSecondary.save(new User(3L, "kaka22", 50));
		log.info(String.valueOf(daoSecondary.findAll().size()));
		// 删除一个User，再验证User总数
		User u = daoSecondary.findById(1L).get();
		log.info(u.toString());
		daoSecondary.delete(u);
		log.info(String.valueOf(daoSecondary.findAll().size()));
		// 删除一个User，再验证User总数
		u = daoSecondary.findByUsername("mama22");
		log.info(u.toString());
		daoSecondary.delete(u);
		log.info(String.valueOf(daoSecondary.findAll().size()));
	}
}
