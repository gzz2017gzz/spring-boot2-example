package com.gzz.model;

import java.io.Serializable;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String pass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", pass='" + pass + '\'' + '}';
	}
}
