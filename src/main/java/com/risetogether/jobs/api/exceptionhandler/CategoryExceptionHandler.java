package com.risetogether.jobs.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.risetogether.jobs.api.exception.CategoryNotfoundByIdException;
import com.risetogether.jobs.api.exception.JobPostNotFoundByIdException;
import com.risetogether.jobs.api.exception.NoCategoriesFoundException;
import com.risetogether.jobs.api.util.AppResponseBuilder;
import com.risetogether.jobs.api.util.ErrorStructure;

@RestControllerAdvice
public class CategoryExceptionHandler {
	
	private final AppResponseBuilder response;

	public CategoryExceptionHandler(AppResponseBuilder response) {
		super();
		this.response = response;
	}
	
	@ExceptionHandler(CategoryNotfoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> handleCategoryNotfoundById(CategoryNotfoundByIdException ex){
		return response.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Category Not Found By Id");
	}
	
	
	@ExceptionHandler(NoCategoriesFoundException.class)
	public ResponseEntity<ErrorStructure<String>> handleNoCategoriesFound(NoCategoriesFoundException ex){
		return response.error(HttpStatus.NOT_FOUND, ex.getMessage(), "No Categories Found");
	}
	
	@ExceptionHandler(JobPostNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> handleJobPostNotFoundById(JobPostNotFoundByIdException ex){
		return response.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Job Post Not found By Id");
	}
}
