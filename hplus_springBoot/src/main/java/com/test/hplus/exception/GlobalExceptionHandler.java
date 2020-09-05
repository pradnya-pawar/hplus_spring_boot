package com.test.hplus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //To handle exception which occurs in Application 
public class GlobalExceptionHandler {
	
	@ExceptionHandler(com.test.hplus.exception.ApplicationException.class)//to tellthat this class exception has to be handled
	public String exceptionHandler() {
		System.out.println("In Global Exception");
		return "error";
	}
//If you have @ExceptionHandler and ControllerAdvice both,@ExceptionHandler is going to picked up.
	
	@ExceptionHandler(LoginFailureException.class)//to tellthat this class exception has to be handled
	public ResponseEntity handleLoginFailure(LoginFailureException ex) {
		System.out.println("In Login Exception");
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
		
	}
}
