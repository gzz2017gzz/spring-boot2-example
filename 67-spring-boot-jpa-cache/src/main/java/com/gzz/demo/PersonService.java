package com.gzz.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	@CachePut(value = "people", key = "#person.id")
	public Person save(Person person) {
		return dao.save(person);
	}

	@CacheEvict(value = "people")
	public void remove(Long id) {
		dao.deleteById(id);
	}

	@Cacheable(value = "people", key = "#id")
	public Person findOne(Long id) {
		return dao.findById(id).get();
	}
}
