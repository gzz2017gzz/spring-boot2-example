package com.gzz.base;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	private List<T> content = new ArrayList<>();
	private int pageSize = 10;
	private long rowCount;
	private int curpage = 0;
	private int pageCount;

	public Page(List<T> dataList, int curpage, long rowCount, int pagesize, int pageCount) {
		this.content.addAll(dataList);
		this.pageSize = pagesize;
		this.rowCount = rowCount;
		this.curpage = curpage;
		this.pageCount = pageCount;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
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
