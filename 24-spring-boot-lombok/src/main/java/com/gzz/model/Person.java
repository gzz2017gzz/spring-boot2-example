package com.gzz.model;

import java.util.Date;

import lombok.Data;

@Data
public class Person {
	private Long id;// 主键
	private Date birthday;// 生日
	private String name;// 姓名
}