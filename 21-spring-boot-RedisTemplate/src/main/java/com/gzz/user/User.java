package com.gzz.user;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	public String member_no;
	public Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", member_no=" + member_no + ", age=" + age + "]";
	}

}
