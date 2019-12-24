package com.gzz.dao.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gzz.model.User;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public interface UserDaoSecondary extends MongoRepository<User, Long> {
	User findByUsername(String username);
}
