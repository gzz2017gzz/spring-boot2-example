package com.gzz.common.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【反回结果的包装】
 * @author 高振中
 * @date 2020-03-17 16:51:20
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "【响应体】")
public class Result<T> {

	static final int OK = 400;
	static final int ERROR = -400;

	static final String SUCCESS = "SUCCESS";
	static final String FAILURE = "FAILURE";

	@ApiModelProperty("状态码")
	private Integer code;
	@ApiModelProperty("提示信息")
	private String msg;
	@ApiModelProperty("响应数据")
	private T data;

	public Result(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	/**
	 * @方法说明 【提示成功没数据】
	 **/
	public static <T> Result<T> success() {
		return new Result<>(OK, SUCCESS);
	}

	/**
	 * @方法说明 【提示成功有数据】
	 **/
	public static <T> Result<T> success(T data) {
		return new Result<>(OK, SUCCESS, data);
	}

	/**
	 * @方法说明 【自定义编码,自定义提示信息,有数据】
	 **/
	public static <T> Result<T> error(Integer code, String msg, T data) {
		return new Result<>(code, msg, data);
	}

	/**
	 * @方法说明 【只提示失败没有数据】
	 **/
	public static <T> Result<T> error() {
		return new Result<>(ERROR, FAILURE);
	}

	/**
	 * @方法说明 【自定义编码,自定义提示信息】
	 **/
	public static <T> Result<T> error(Integer code, String msg) {
		return new Result<>(code, msg);
	}

}
