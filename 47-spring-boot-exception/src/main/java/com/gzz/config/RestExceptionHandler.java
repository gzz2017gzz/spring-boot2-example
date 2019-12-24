package com.gzz.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@RestControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {
	@ExceptionHandler
//	@ResponseStatus
//	@ResponseBody
	public ApiResult<String> runtimeExceptionHandler(Exception e) {
		return ApiResult.error(e);
	}
}
