package com.gzz.dao;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
public class BaseUser {

	private Integer id;
	private String name;
	private byte[] remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getRemark() {
		return remark;
	}

	public void setRemark(byte[] remark) {
		this.remark = remark;
	}

}
