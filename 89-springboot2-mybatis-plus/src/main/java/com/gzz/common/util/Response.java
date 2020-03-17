package com.gzz.common.util;

import lombok.Data;

@Data
public class Response<T> {

	private String errorCode;
	private String errorMessage;
	private String extMessage;
	private T result;
	private Status status;

	public Response() {
		this.status = Status.SUCCEED;
	}

	public static <T> Response<T> success() {
		return new Response<>();
	}

	public static <T> Response<T> success(T result) {
		Response<T> response = new Response<>();
		response.setResult(result);
		return response;
	}

	public static <T> Response<T> failure(String errorCode, String errorMessage) {
		Response<T> response = new Response<>();
		response.errorCode = errorCode;
		response.errorMessage = errorMessage;
		response.status = Status.FAILED;
		return response;
	}

	public static <T> Response<T> failure(String message) {
		Response<T> response = new Response<>();
		response.setErrorMessage(message);
		response.status = Status.FAILED;
		return response;
	}

	public static <T> Response<T> warring(T result) {
		Response<T> response = new Response<>();
		response.setResult(result);
		response.status = Status.WARRING;
		return response;
	}

	public enum Status {
		/**
		 * 状态
		 */
		SUCCEED, WARRING, FAILED;

		Status() {
		}
	}
}