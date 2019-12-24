package com.gzz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gzz.entity.User;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
public interface UserDao extends JpaRepository<User, Long> {

	User findById(long id);

	void deleteById(Long id);
}