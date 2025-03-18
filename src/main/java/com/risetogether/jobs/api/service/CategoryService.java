package com.risetogether.jobs.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.risetogether.jobs.api.entity.Category;
import com.risetogether.jobs.api.mapper.CategoryMapper;
import com.risetogether.jobs.api.repository.CategoryRepository;
import com.risetogether.jobs.api.requestdto.CategoryRequest;

@Service
public class CategoryService {
		
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	public Category saveCategory(CategoryRequest categoryRequest) {
		return categoryRepository.save(categoryMapper.mapToCategory(categoryRequest, new Category()));
	}

	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
	
	
}
