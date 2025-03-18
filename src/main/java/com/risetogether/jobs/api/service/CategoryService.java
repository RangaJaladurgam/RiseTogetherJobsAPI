package com.risetogether.jobs.api.service;

import org.springframework.stereotype.Service;

import com.risetogether.jobs.api.mapper.CategoryMapper;
import com.risetogether.jobs.api.repository.CategoryRepository;

@Service
public class CategoryService {
		
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}
	
	
}
