package com.gzz.model;

import java.io.Serializable;

public class UserCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Short age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

}
