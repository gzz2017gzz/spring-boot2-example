package com.gzz.sys.userrole;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @类说明 [用户角色关系]实体类
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
	private Long user_id; // 用户主键
	private Long role_id; // 角色主键
}