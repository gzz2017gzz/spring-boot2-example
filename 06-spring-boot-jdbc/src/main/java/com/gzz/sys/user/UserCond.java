package com.gzz.sys.user;

import java.util.Date;

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
		add(birthday, "AND t.birthday = ?");
		add(gender, "AND t.gender = ?");
		add(ids, "AND t.id IN ");
	}

	// 查询条件,把不用的条件清理掉
	private Integer id;// 主键
	private String name;// 姓名
	private Date birthday;// 生日
	private Byte gender;// 性别
	private Object ids[];// 主键列表

}