package com.gzz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jpa_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique = true) // 名字上有唯一索引，重复会报
	private String userName;
	@Column(nullable = false, length = 50)
	private String password;
	@Column(nullable = false)
	private int age;

	public long getId() {
		return id;
	}

	public User setId(long id) {
		this.id = id;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public int getAge() {
		return age;
	}

	public User setAge(int age) {
		this.age = age;
		return this;
	}
}
