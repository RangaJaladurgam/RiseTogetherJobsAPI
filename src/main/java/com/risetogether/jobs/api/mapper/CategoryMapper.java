package com.risetogether.jobs.api.mapper;

import org.springframework.stereotype.Component;

import com.risetogether.jobs.api.entity.Category;
import com.risetogether.jobs.api.requestdto.CategoryRequest;

@Component
public class CategoryMapper {
	
	public Category mapToCategory(CategoryRequest categoryRequest,Category category) {
		category.setName(categoryRequest.getName());
		return category;
	}
}
