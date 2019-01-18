package com.gzz.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {
	@ExceptionHandler
//	@ResponseStatus
//	@ResponseBody
	public ApiResult<String> runtimeExceptionHandler(Exception e) {
		return ApiResult.error(e);
	}
}
