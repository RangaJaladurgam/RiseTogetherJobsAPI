package com.risetogether.jobs.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.risetogether.jobs.api.service.CategoryService;
import com.risetogether.jobs.api.util.AppResponseBuilder;

@RestController
public class CategoryController {
	
	private final CategoryService categoryService;
	private final AppResponseBuilder response;
	
	public CategoryController(CategoryService categoryService, AppResponseBuilder response) {
		super();
		this.categoryService = categoryService;
		this.response = response;
	}
	
	
	
	
	
	
}
