package com.risetogether.jobs.api.exception;

public class CategoryNotfoundByIdException extends RuntimeException{
	
	private String message;

	public CategoryNotfoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
