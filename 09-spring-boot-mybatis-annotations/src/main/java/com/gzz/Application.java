package com.gzz;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.dao.PersonDao;
import com.gzz.domain.Person;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private PersonDao personMapper;

//	@PostConstruct
	public Integer save() {
		Person personDO = new Person();
		personDO.setName("张三");
		personDO.setAge(18);
		personMapper.insert(personDO);
		return personDO.getId();
	}
//	@PostConstruct
	public Long update() {
		Person personDO = new Person();
		personDO.setId(2);
		personDO.setName("旺旺");
		personDO.setAge(12);
		return personMapper.update(personDO);
	}
//	@PostConstruct
	public Long delete() {
		return personMapper.delete(1L);
	}
	@PostConstruct
	public Person selectById() {
		return personMapper.selectById(2L);
	}

	public List<Person> selectAll() {
		return personMapper.selectAll();
	}

	@Transactional // 需要事务的时候加上
	public Boolean transaction() {
		delete();

		@SuppressWarnings("unused")
		int i = 3 / 0;

		save();

		return true;
	}

}
