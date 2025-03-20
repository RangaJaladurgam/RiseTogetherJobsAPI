package com.risetogether.jobs.api.exception;


public class JobPostNotFoundByIdException extends RuntimeException{
	
	private String message;

	public JobPostNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
