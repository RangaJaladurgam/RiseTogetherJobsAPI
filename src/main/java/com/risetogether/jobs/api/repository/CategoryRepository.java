package com.risetogether.jobs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.risetogether.jobs.api.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, String>{
	
}
