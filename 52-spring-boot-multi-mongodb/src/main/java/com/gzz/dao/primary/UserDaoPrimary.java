package com.gzz.dao.primary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gzz.model.User;

 
public interface UserDaoPrimary extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
