package com.risetogether.jobs.api.exception;

public class AdminNotFoundByEmailException extends RuntimeException{
	
	private String message;

	public AdminNotFoundByEmailException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	
}
