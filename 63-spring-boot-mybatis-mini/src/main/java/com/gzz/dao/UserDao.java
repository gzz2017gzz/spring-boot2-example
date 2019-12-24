package com.gzz.dao;

import org.apache.ibatis.annotations.Param;

import com.gzz.model.User;

import org.apache.ibatis.annotations.Mapper;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Mapper
public interface UserDao {

	int insertUser(@Param("user") User user);

	User findByName(String name);
}
