package com.gzz.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
	private Long id;// 主键
	private Date birthday;// 生日
	private String name;// 姓名
}