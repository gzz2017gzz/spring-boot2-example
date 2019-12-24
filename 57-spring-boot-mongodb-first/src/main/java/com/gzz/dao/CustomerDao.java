package com.gzz.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gzz.model.Customer;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public interface CustomerDao extends MongoRepository<Customer, String> {

	Customer findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);

}