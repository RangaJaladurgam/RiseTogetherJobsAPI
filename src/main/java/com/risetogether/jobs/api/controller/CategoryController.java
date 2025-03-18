package com.risetogether.jobs.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.risetogether.jobs.api.entity.Category;
import com.risetogether.jobs.api.requestdto.CategoryRequest;
import com.risetogether.jobs.api.service.CategoryService;
import com.risetogether.jobs.api.util.AppResponseBuilder;
import com.risetogether.jobs.api.util.ResponseStructure;

@RestController
public class CategoryController {
	
	private final CategoryService categoryService;
	private final AppResponseBuilder response;
	
	public CategoryController(CategoryService categoryService, AppResponseBuilder response) {
		super();
		this.categoryService = categoryService;
		this.response = response;
	}
	
	@PostMapping("/categories")
	public ResponseEntity<ResponseStructure<Category>> saveCategory(@RequestBody CategoryRequest categoryRequest){
		Category category = categoryService.saveCategory(categoryRequest);
		return response.success(HttpStatus.CREATED, "Category created successfully", category);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<ResponseStructure<List<Category>>> findAllCategories(){
		List<Category> categories = categoryService.findAllCategories();
		return response.success(HttpStatus.FOUND, "Categories found successfully", categories);
	}
	
}
