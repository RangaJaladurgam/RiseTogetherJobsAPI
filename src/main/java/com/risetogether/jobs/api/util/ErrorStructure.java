package com.risetogether.jobs.api.util;

import org.springframework.http.HttpStatus;

public class ErrorStructure<T> {
	
	private int status;
	private String message;
	private T rootCause;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getRootCause() {
		return rootCause;
	}
	public void setRootCause(T rootCause) {
		this.rootCause = rootCause;
	}
	
	public static <T> ErrorStructure<T> create(HttpStatus status,String message,T rootCause){
		ErrorStructure<T> error = new ErrorStructure<T>();
		error.setStatus(status.value());
		error.setMessage(message);
		error.setRootCause(rootCause);
		return error;
	}
	
}
