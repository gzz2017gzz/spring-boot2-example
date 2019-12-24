package com.gzz.sys.rolefunction;

import com.gzz.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 [角色功能关系]查询条件实体
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleFunctionCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add(role_id, "AND t.role_id = ?");
		add(function_id, "AND t.function_id = ?");
	}

	private Long role_id; // 角色主键
	private Long function_id; // 功能主键
}