package com.gzz.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Long id;// 主键
	private Date birthday;// 生日
	private String name;// 姓名
}