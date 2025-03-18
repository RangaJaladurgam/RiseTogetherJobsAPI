package com.risetogether.jobs.api.exception;

public class NoCategoriesFoundException extends RuntimeException {

	private String message;

	public NoCategoriesFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
