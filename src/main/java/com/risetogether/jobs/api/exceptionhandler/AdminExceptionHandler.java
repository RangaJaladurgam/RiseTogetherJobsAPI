package com.risetogether.jobs.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.risetogether.jobs.api.exception.AdminNotFoundByEmailException;
import com.risetogether.jobs.api.exception.NoAdminsFoundException;
import com.risetogether.jobs.api.util.AppResponseBuilder;
import com.risetogether.jobs.api.util.ErrorStructure;

@RestControllerAdvice
public class AdminExceptionHandler {
	
	private final AppResponseBuilder response;

	public AdminExceptionHandler(AppResponseBuilder response) {
		super();
		this.response = response;
	}
	
	@ExceptionHandler(AdminNotFoundByEmailException.class)
	public ResponseEntity<ErrorStructure<String>> handleAdminNotFoundByEmail(AdminNotFoundByEmailException ex){
		return response.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Admin not found by Email");
	}
	
	@ExceptionHandler(NoAdminsFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handleNoAdminsFound(NoAdminsFoundException ex){
		return response.error(HttpStatus.NOT_FOUND, ex.getMessage(), "No Admins Found");
	}
}
