package com.lcwd.hotel.exception;

public class ResourseNotFoundException extends RuntimeException{
	
	public ResourseNotFoundException() {
		super("Resourse not found exception ");
	}
	
	public ResourseNotFoundException(String message) {
		super(message);
	}

}
