package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
//@Slf4j
@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

//	@Autowired
//	private UserDao dao;
//
//	@PostConstruct
//	public void run() {
//
//		UserCond cond = UserCond.builder()//
//				.gender((byte) 1)//
//				.ids(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 })//
//				.build();
//		List<User> list = dao.queryList(cond);
//		log.info("list={}", list);
//		
//		int delete = dao.delete(new Integer[] { 1, 2, 3 });
//		log.info("count={}", delete);
//	}
}
