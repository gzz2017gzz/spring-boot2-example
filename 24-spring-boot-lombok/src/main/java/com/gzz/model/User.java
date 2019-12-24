package com.gzz.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Getter
@Setter
public class User {
	private Long id;// 主键
	private Date birthday;// 生日
	private String name;// 姓名
}