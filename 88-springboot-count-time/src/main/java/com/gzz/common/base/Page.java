package com.gzz.common.base;

import java.util.ArrayList;
import java.util.List;
/**
 * @功能描述:分页工具
 * @author http://www.gaozz.club
 * @date 2018-07-13
 */
public class Page<T> {
	private List<T> dataList = new ArrayList<>();// 数据列表
	private int pageSize = 10;// 页大小
	private long rowCount;// 记录数
	private int curpage = 0;// 当前页
	private int pageCount;// 总页数

	public Page(List<T> dataList, int curpage, long rowCount, int pagesize, int pageCount) {
		this.dataList.addAll(dataList);
		this.pageSize = pagesize;
		this.rowCount = rowCount;
		this.curpage = curpage;
		this.pageCount = pageCount;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
