package com.gzz.dao;

import org.apache.ibatis.annotations.Param;

import com.gzz.model.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

	int insertUser(@Param("user") User user);

	User findByName(String name);
}
