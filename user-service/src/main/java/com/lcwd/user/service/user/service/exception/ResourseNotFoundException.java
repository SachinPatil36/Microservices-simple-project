package com.lcwd.user.service.user.service.exception;

public class ResourseNotFoundException extends RuntimeException{

	public ResourseNotFoundException() {
		super("Resorse Not Found Exception!!");
		
		
		
	}

	public ResourseNotFoundException(String message) {
		
		super(message);
		
	}

	
	

}
