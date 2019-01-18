package com.gzz.user.model;

import java.util.Date;

import com.gzz.common.base.BaseCondition;

import lombok.Getter;
import lombok.Setter;

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
