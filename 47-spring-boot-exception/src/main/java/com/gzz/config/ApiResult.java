package com.gzz.config;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ApiResult<T> {
	private boolean success = true;
	private T data;
	private int code;
	private String msg;

	public ApiResult() {
		super();
	}

	public ApiResult(T data, int code) {
		super();
		this.success=true;
		this.data = data;
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static ApiResult<String> error(Throwable t) {
		ApiResult<String> result = new ApiResult<>();
		result.setCode(-1);
		result.setSuccess(false);
		result.setMsg(t.getMessage());
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		result.setData(stringWriter.getBuffer().toString());
		return result;
	}

}
