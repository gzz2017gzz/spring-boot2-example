package com.gzz.mvc

import com.gzz.base.BaseCondition

data class UserCond(
		var id: Long?,
		var password: String?,
		var name: String?,
		var login_id: String?
) : BaseCondition() {
	override fun addCondition() {
		add(name, " and name=?");
		add(id, " and id=?");
	}
}
 
 
