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
 * @author 高振中
 * @date 2019-12-20 18:28:06
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
		add(name, "AND t.name LIKE ?", 3);
		add(sex, "AND t.sex LIKE ?", 3);
		add(age, "AND t.age = ?");
		add(phone, "AND t.phone LIKE ?", 3);
		add(create_time, "AND t.create_time = ?");
	}

	private Integer id; // 主键
	private String name; // 姓名
	private String sex; // 性别
	private Integer age; // 年龄
	private String phone; // 电话
	private Date create_time; // 创建时间

}