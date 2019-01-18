package com.gzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gzz.domain.Person;

@Mapper
public interface PersonDao {

	@Update("insert into person(name,age) values(#{name},#{age})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	void insert(Person personDO);

	@Update("update person set name=#{name},age=#{age} where id=#{id}")
	Long update(Person personDO);

	@Update("delete from person where id=#{id}")
	Long delete(@Param("id") Long id);

	@Select("select id,name,age from person")
	List<Person> selectAll();

	@Select("select id,name,age from person where id=#{id}")
	Person selectById(@Param("id") Long id);
}
