package com.risetogether.jobs.api.mapper;

import org.springframework.stereotype.Component;

import com.risetogether.jobs.api.entity.JobPost;
import com.risetogether.jobs.api.requestdto.JobPostRequest;
import com.risetogether.jobs.api.responsedto.JobPostResponse;

@Component
public class JobPostMapper {
	
	private final AdminMapper adminMapper;
	
	
	public JobPostMapper(AdminMapper adminMapper) {
		super();
		this.adminMapper = adminMapper;
	}

	public JobPost mapToJobPost(JobPostRequest jobPostRequest,JobPost jobPost) {
		jobPost.setTitle(jobPostRequest.getTitle());
		jobPost.setDescription(jobPostRequest.getDescription());
		jobPost.setQualifications(jobPostRequest.getQualifications());
		jobPost.setLocation(jobPostRequest.getLocation());
		jobPost.setImageUrl(jobPostRequest.getImageUrl());
		jobPost.setExpireDate(jobPostRequest.getExpireDate());
		jobPost.setPassOutYears(jobPostRequest.getPassOutYears());
		jobPost.setApplyLink(jobPostRequest.getApplyLink());
		return jobPost;
	}
	
	public JobPostResponse mapToJobPostResponse(JobPost jobPost) {
		JobPostResponse response = new JobPostResponse();
		response.setJobPostId(jobPost.getJobPostId());
		response.setTitle(jobPost.getTitle());
		response.setDescription(jobPost.getDescription());
		response.setQualifications(jobPost.getQualifications());
		response.setLocation(jobPost.getLocation());
		response.setImageUrl(jobPost.getImageUrl());
		response.setCreatedAt(jobPost.getCreatedAt());
		response.setExpireDate(jobPost.getExpireDate());
		response.setCategory(jobPost.getCategory());
		response.setAdminResponse(adminMapper.mapToAdminRespone( jobPost.getAdmin()));
		response.setPassOutYears(jobPost.getPassOutYears());
		response.setApplyLink(jobPost.getApplyLink());
		return response;
	}
}
