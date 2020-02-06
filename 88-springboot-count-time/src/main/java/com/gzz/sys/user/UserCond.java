package com.gzz.sys.user;

import java.util.Date;
import java.util.List;

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
		add(birthday, "AND t.birthday = ?");
		add(gender, "AND t.gender = ?");
		add(ids, "AND t.id IN ");
	}

	// 查询条件,把不用的条件清理掉
	private Long id;// 主键
	private String name;// 姓名
	private Date birthday;// 生日
	private Byte gender;// 性别
	private List<Long> ids;// 主键列表

}