package com.gzz.sys.user;

import java.util.Date;
import java.util.List;

import com.gzz.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @类说明 【用户】查询条件
 * @author 高振中
 * @date 2020-03-18 13:56:40
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户查询条件")
public class UserCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add("AND t.id = ?", id);
		add("AND t.name LIKE ?", name, 3);
		add("AND t.birthday = ?", birthday);
		add("AND t.gender = ?", gender);
		add("AND t.id IN", ids);
	}

	// 以下为查询条件
	@ApiModelProperty("主键")
	private Long id; // 主键
	@ApiModelProperty("姓名")
	private String name; // 姓名
	@ApiModelProperty("生日")
	private Date birthday; // 生日
	@ApiModelProperty("性别")
	private Byte gender; // 性别
	@ApiModelProperty("主键数组")
	private List<Object> ids;// 主键列表
	// 以下为自定义查询条件
}