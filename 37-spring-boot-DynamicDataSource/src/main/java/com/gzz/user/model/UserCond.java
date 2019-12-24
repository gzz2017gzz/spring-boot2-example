package com.gzz.user.model;

import java.util.Date;

import com.gzz.common.base.BaseCondition;

import lombok.Getter;
import lombok.Setter;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Setter
@Getter
public class UserCond extends BaseCondition {

	@Override
	public void addCondition() {
	}

	private Integer id;
	private String name;
	private Date birthday;

}
