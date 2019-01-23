package com.gzz.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gzz.model.Customer;

public interface CustomerDao extends MongoRepository<Customer, String> {

	Customer findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);

}