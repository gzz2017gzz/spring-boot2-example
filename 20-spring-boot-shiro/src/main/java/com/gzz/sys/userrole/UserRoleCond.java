package com.gzz.sys.userrole;

import com.gzz.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 [用户角色关系]查询条件实体
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add(user_id, "AND t.user_id = ?");
		add(role_id, "AND t.role_id = ?");
	}

	private Long user_id; // 用户主键
	private Long role_id; // 角色主键
}