package com.gzz.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
	private Integer code;
	private String msg;
	private T data;

	public Result(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public static <T> Result<T> success(T data) {
		return new Result<>(2000, "请求成功", data);
	}

	public static <T> Result<T> success() {
		return new Result<>(2000, "请求成功");
	}

//	public static <T> Result<T> success(Integer code, String msg, T data) {
//		return new Result<>(code, msg, data);
//	}

	public static <T> Result<T> error(Integer code, String msg, T data) {
		return new Result<>(code, msg, data);
	}

	public static <T> Result<T> error(Integer code, String msg) {
		return new Result<>(code, msg);
	}

	public static <T> Result<T> error(T data) {
		return new Result<>(4000, "请求异常", data);
	}

}
