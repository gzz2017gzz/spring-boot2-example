package com.gzz.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
	private Integer code;
	private String msg;
	private Object data;

	public Result(Integer code, String msg) {
		this.msg = msg;
		this.code = code;
	}

	public Result(String msg, Integer code, Object data) {
		this.msg = msg;
		this.code = code;
		this.data = data;
	}

	public static Result success(Object data) {
		return new Result(2000, "请求成功", data);
	}

	public static Result error(Object data) {
		return new Result(4000, "请求异常", data);
	}

	public static Result success(Integer code, String msg, Object data) {
		return new Result(code, msg, data);
	}

	public static Result success(Integer code, String msg) {
		return new Result(code, msg);
	}

	public static Result error(Integer code, String msg, Object data) {
		return new Result(code, msg, data);
	}

	public static Result error(Integer code, String msg) {
		return new Result(code, msg);
	}
}
