package com.gzz.model;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public class User {
	private Long id;
	private String username;
	private Integer age;

	public User(Long id, String username, Integer age) {
		this.id = id;
		this.username = username;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "\"User:{\"id\":\"" + id + "\",\"username\":\"" + username + "\",\"age\":\"" + age + "\"}\"";
	}
}