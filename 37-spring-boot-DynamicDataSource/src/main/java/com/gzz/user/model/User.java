package com.gzz.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String name;
	private Date birthday;
}
