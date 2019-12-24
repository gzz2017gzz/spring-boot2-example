package com.gzz.exception;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public class HttpServletException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpServletException(String message) {
		super(message);
	}

	public HttpServletException(String message, Throwable cause) {
		super(message, cause);
	}
}
