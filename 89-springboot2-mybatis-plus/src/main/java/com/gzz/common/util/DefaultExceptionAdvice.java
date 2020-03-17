package com.gzz.common.util;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @类说明 【全局异常处理】
 * @author 高振中
 * @date 2020-03-11 17:57:13
 **/
@ResponseBody
@ControllerAdvice
public class DefaultExceptionAdvice {
	/**
	 * @类说明 【参数校验异常】
	 **/
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Response handleException(MethodArgumentNotValidException ex) {
		return Response.failure("参数验证出错", ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString());
	}
}
