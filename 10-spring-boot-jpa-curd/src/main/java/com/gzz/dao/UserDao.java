package com.gzz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gzz.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findById(long id);

	void deleteById(Long id);
}