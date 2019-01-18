package com.gzz.sys.user;

import java.io.Serializable;
import java.util.Date;

public class UserCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Date birthday;

	public UserCondition(Integer id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserCondition [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

}
