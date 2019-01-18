package com.gzz.sys.user;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @类说明 [用户]实体类
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Long id; // 主键
	private String name; // 用户名
	private String password; // 密码
	private String salt; // 盐
	private Byte locked; // 是否锁定
}