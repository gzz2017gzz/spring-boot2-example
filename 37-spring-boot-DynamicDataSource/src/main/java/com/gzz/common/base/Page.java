package com.gzz.common.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @功能描述:分页数据
 * @author gzz_gzz@163.com
 * @date 2018-02-15
 */
public class Page<T> {

	private List<T> dataList = new ArrayList<>();
	private int pageSize = 10;// 页大小(每页记录条)
	private long rowCount;// 记录总数
	private int curpage = 0;// 当前页码

	public Page(List<T> dataList, int curpage, long rowCount, int pagesize) {
		this.dataList.addAll(dataList);
		this.pageSize = pagesize;
		this.rowCount = rowCount;
		this.curpage = curpage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getRowCount() {
		return rowCount;
	}

	public long getPageCount() {
		return rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
	}

	public int getCurpage() {
		return curpage;
	}

}
