package com.springboot.angular.SpringBootBackEnd.controller;

import java.util.function.Supplier;

public class ResourceNotFoundException extends RuntimeException {
	
	
public ResourceNotFoundException() {
	super("Employee NOt Found by Id");
}

public ResourceNotFoundException(String string) {
	super(string);
}
	

}
