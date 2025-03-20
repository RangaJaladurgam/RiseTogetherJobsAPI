package com.risetogether.jobs.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.risetogether.jobs.api.entity.JobPost;

public interface JobPostRepository extends JpaRepository<JobPost, String>{
	
	@Query("SELECT j FROM JobPost j WHERE j.category.categoryId=:categoryId")
	public List<JobPost> findJobsByCategoryId(@Param("categoryId") String categoryId);
}
