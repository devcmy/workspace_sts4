package com.itwill.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * 전역(모든)콘트롤러의 공통예외를 처리하기위한 ControllerAdvice
 */

@ControllerAdvice
public class GlobalCommonExceptionControllerAdvice {
	@ExceptionHandler(Exception.class)
	public String handle_exception(Exception e) {
		return "global_error_result";
	}

	@ExceptionHandler(RuntimeException.class)
	public String handle_runtime_exception(RuntimeException e) {
		return "global_error_result";
	}
	
}
