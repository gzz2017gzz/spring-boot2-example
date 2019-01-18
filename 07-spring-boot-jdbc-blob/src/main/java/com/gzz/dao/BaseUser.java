package com.gzz.dao;

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
