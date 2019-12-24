package com.gzz.sys.user;

import com.gzz.common.base.BaseCondition;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @类说明:用户查询条件实体类
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
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