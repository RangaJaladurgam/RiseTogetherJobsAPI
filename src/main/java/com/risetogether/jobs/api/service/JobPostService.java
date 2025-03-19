package com.risetogether.jobs.api.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.risetogether.jobs.api.entity.Admin;
import com.risetogether.jobs.api.entity.Category;
import com.risetogether.jobs.api.entity.JobPost;
import com.risetogether.jobs.api.exception.AdminNotFoundByEmailException;
import com.risetogether.jobs.api.exception.CategoryNotfoundByIdException;
import com.risetogether.jobs.api.mapper.JobPostMapper;
import com.risetogether.jobs.api.repository.AdminRepository;
import com.risetogether.jobs.api.repository.CategoryRepository;
import com.risetogether.jobs.api.repository.JobPostRepository;
import com.risetogether.jobs.api.requestdto.JobPostRequest;
import com.risetogether.jobs.api.responsedto.JobPostResponse;

@Service
public class JobPostService {
	
	private final JobPostRepository jobPostRepository;
	private final AdminRepository adminRepository; 
	private final CategoryRepository categoryRepository;
	private final JobPostMapper jobPostMapper;
	
	public JobPostService(JobPostRepository jobPostRepository, JobPostMapper jobPostMapper, CategoryRepository categoryRepository, AdminRepository adminRepository) {
		super();
		this.jobPostRepository = jobPostRepository;
		this.adminRepository = adminRepository;
		this.categoryRepository = categoryRepository;
		this.jobPostMapper = jobPostMapper;
	}

	public JobPostResponse saveJobPost(JobPostRequest jobPostRequest,String email,String categoryId) {
		JobPost jobPost = jobPostMapper.mapToJobPost(jobPostRequest, new JobPost());
		
		Admin admin = adminRepository.findAdminByEmail(email)
									 .orElseThrow(()-> new AdminNotFoundByEmailException("Failed to save Job Post"));
		Category category = categoryRepository.findById(categoryId)
									.orElseThrow(()-> new CategoryNotfoundByIdException("Failed to save Job Post"));
		
		jobPost.setAdmin(admin);
		jobPost.setCategory(category);
		jobPost.setCreatedAt(LocalDateTime.now());
		return jobPostMapper.mapToJobPostResponse(jobPostRepository.save(jobPost));
		
	}
	
	
}
