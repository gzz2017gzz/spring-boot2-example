package com.gzz.sys.user;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import com.gzz.common.base.BaseCondition;

/**
 * @类说明 [user]查询条件实体
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
		add("AND t.id = ?", id);
		add("AND t.name LIKE ?", name, 3);
		add("AND t.sex LIKE ?", sex, 3);
		add("AND t.age = ?", age);
		add("AND t.phone LIKE ?", phone, 3);
		add("AND t.create_time = ?", create_time);
	}

	private Integer id; // 主键
	private String name; // 姓名
	private String sex; // 性别
	private Integer age; // 年龄
	private String phone; // 电话
	private Date create_time; // 创建时间

}