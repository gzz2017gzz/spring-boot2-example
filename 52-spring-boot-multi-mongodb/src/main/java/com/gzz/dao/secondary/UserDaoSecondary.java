package com.gzz.dao.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gzz.model.User;

public interface UserDaoSecondary extends MongoRepository<User, Long> {
	User findByUsername(String username);
}
