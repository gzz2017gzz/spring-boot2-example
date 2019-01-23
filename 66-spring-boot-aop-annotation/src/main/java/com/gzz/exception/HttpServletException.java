package com.gzz.exception;

public class HttpServletException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpServletException(String message) {
		super(message);
	}

	public HttpServletException(String message, Throwable cause) {
		super(message, cause);
	}
}
