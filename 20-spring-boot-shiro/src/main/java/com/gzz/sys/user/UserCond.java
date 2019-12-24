package com.gzz.sys.user;

import com.gzz.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 [用户]查询条件实体
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add(id, "AND t.id = ?");
		add(name, "AND t.name = ?");
		add(password, "AND t.password LIKE ?", 3);
		add(salt, "AND t.salt LIKE ?", 3);
		add(locked, "AND t.locked = ?");
	}

	private Long id; // 主键
	private String name; // 用户名
	private String password; // 密码
	private String salt; // 盐
	private Byte locked; // 是否锁定
}