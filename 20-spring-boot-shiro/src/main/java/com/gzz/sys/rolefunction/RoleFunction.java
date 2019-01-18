package com.gzz.sys.rolefunction;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @类说明 [角色功能关系]实体类
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleFunction {
	private Long role_id; // 角色主键
	private Long function_id; // 功能主键
}