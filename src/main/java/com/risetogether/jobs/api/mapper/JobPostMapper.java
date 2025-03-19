package com.risetogether.jobs.api.mapper;

import org.springframework.stereotype.Component;

import com.risetogether.jobs.api.entity.JobPost;
import com.risetogether.jobs.api.requestdto.JobPostRequest;
import com.risetogether.jobs.api.responsedto.JobPostResponse;

@Component
public class JobPostMapper {
	
	public JobPost mapToJobPost(JobPostRequest jobPostRequest,JobPost jobPost) {
		jobPost.setTitle(jobPostRequest.getTitle());
		jobPost.setDescription(jobPostRequest.getDescription());
		jobPost.setLocation(jobPostRequest.getLocation());
		jobPost.setImageUrl(jobPostRequest.getImageUrl());
		jobPost.setExpireDate(jobPostRequest.getExpireDate());
		return jobPost;
	}
	
	public JobPostResponse mapToJobPostResponse(JobPost jobPost) {
		JobPostResponse response = new JobPostResponse();
		response.setJobPostId(jobPost.getJobPostId());
		response.setTitle(jobPost.getTitle());
		response.setDescription(jobPost.getDescription());
		response.setLocation(jobPost.getLocation());
		response.setImageUrl(jobPost.getImageUrl());
		response.setCreatedAt(jobPost.getCreatedAt());
		response.setExpireDate(jobPost.getExpireDate());
		response.setCategory(jobPost.getCategory());
		return response;
	}
}
