package com.gzz.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("图书")
public class Book {
	@ApiModelProperty(name = "主键", dataType = "Long")
	private long id;
	@ApiModelProperty(name = "名称", dataType = "String")
	private String name;
	@ApiModelProperty(name = "价格", dataType = "Double")
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
