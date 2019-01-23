package com.gzz.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private Long id;
	private String userName;
	private String passWord;
}
