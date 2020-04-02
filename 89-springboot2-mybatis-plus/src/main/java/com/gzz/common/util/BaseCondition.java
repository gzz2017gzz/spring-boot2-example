package com.gzz.common.util;

import io.swagger.annotations.ApiModelProperty;

/**
 * @功能说明 拼加页面查询条件的基础类
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2020-02-02 02:20:20
 */
public abstract class BaseCondition {

	@ApiModelProperty("页大小")
	private int size = 10;// 页大小(每页记录条)
	@ApiModelProperty("当前页")
	private int page = 0;// 当前页码

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
