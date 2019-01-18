package com.gzz.sys.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 [角色]实体类
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	private Long id; // 主键
	private String role; // 角色
	private String name; // 名称
	private Byte available; // 是否可用
}