package com.springboot.angular.SpringBootBackEnd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value=HttpStatus.NOT_FOUND)
public class SourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public SourceNotFoundException(String message){
		super(message);
	}
}
