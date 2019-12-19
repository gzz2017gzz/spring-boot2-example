package com.gzz.sys.user;

import com.gzz.common.base.BaseCondition;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @类说明:用户查询条件实体类
 * @author http://www.gaozz.club
 * @date:2018-07-13 10:17:27
 **/
@Setter
@Getter
@Builder
//@Accessors(chain = true)
public class UserCond extends BaseCondition {

	/**
	 * @方法说明:拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add(id, "AND t.id = ?");
		add(name, "AND t.name LIKE ?", 3);
 
	}

	// 查询条件,把不用的条件清理掉
	private Long id;// 主键
	private String name;// 姓名
 

}