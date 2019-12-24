package com.gzz.exception;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public class FormRepeatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FormRepeatException(String message) {
		super(message);
	}

	public FormRepeatException(String message, Throwable cause) {
		super(message, cause);
	}
}
