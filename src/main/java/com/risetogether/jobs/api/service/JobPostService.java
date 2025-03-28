package com.risetogether.jobs.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.risetogether.jobs.api.entity.Admin;
import com.risetogether.jobs.api.entity.Category;
import com.risetogether.jobs.api.entity.JobPost;
import com.risetogether.jobs.api.exception.AdminNotFoundByEmailException;
import com.risetogether.jobs.api.exception.CategoryNotfoundByIdException;
import com.risetogether.jobs.api.exception.JobPostNotFoundByIdException;
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

	public JobPostResponse findJobPost(String jobPostId) {
		return jobPostRepository.findById(jobPostId)
								.map(jobPostMapper::mapToJobPostResponse)
								.orElseThrow(() -> new JobPostNotFoundByIdException("Failed to find JobPost by Id"));
		
		 
	}

	public List<JobPostResponse> findAllJobs() {
		return jobPostRepository.findAll()
								.stream()
								.map(jobPostMapper::mapToJobPostResponse)
								.toList();
	}

	public List<JobPostResponse> findAllJobsByCategory(String categoryId) {
		return jobPostRepository.findJobsByCategoryId(categoryId)
								.stream()
								.map(jobPostMapper::mapToJobPostResponse)
								.toList();
	}

	public String deleteJobPostById(String jobPostId) {
		JobPost jobPost = jobPostRepository.findById(jobPostId)
										   .orElseThrow(() -> new JobPostNotFoundByIdException("Failed to delete JobPost by Id"));
		jobPostRepository.delete(jobPost);
		return "Deleted Successfully";
	}

	public JobPostResponse updateJobPostById(JobPostRequest jobPostRequest,String jobPostId,String categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(()-> new CategoryNotfoundByIdException("Failed to save Job Post"));
		return jobPostRepository.findById(jobPostId).map((exJobPost) -> {
												jobPostMapper.mapToJobPost(jobPostRequest, exJobPost);
												exJobPost.setCategory(category);
												return jobPostRepository.save(exJobPost);
											})
												.map(jobPostMapper::mapToJobPostResponse)
												.orElseThrow(() -> new JobPostNotFoundByIdException("Failed to update JobPost by Id"));
	}

	
	
	
}
