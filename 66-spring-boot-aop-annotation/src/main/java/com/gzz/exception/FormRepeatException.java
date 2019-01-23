package com.gzz.exception;

public class FormRepeatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FormRepeatException(String message) {
		super(message);
	}

	public FormRepeatException(String message, Throwable cause) {
		super(message, cause);
	}
}
