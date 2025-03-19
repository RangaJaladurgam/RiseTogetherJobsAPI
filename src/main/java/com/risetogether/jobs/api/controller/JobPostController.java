package com.risetogether.jobs.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.risetogether.jobs.api.requestdto.JobPostRequest;
import com.risetogether.jobs.api.responsedto.JobPostResponse;
import com.risetogether.jobs.api.service.JobPostService;
import com.risetogether.jobs.api.util.AppResponseBuilder;
import com.risetogether.jobs.api.util.ResponseStructure;

@RestController
public class JobPostController {
	
	private final JobPostService jobPostService;
	private final AppResponseBuilder response;
	
	public JobPostController(JobPostService jobPostService, AppResponseBuilder response) {
		super();
		this.jobPostService = jobPostService;
		this.response = response;
	}
	
	@PostMapping("/jobs/create")
	public ResponseEntity<ResponseStructure<JobPostResponse>> saveJobPost(@RequestBody JobPostRequest jobPostRequest,@RequestParam String email,@RequestParam String categoryId){
		JobPostResponse jobPostResponse = jobPostService.saveJobPost(jobPostRequest,email,categoryId);
		return response.success(HttpStatus.CREATED, "JobPost Created Successfully", jobPostResponse);
	}
	
	@GetMapping("/jobs/{jobPostId}")
	public ResponseEntity<ResponseStructure<JobPostResponse>> findJobPost(@PathVariable String jobPostId){
		JobPostResponse jobPostResponse = jobPostService.findJobPost(jobPostId);
		return response.success(HttpStatus.FOUND, "JobPost Found Successfully", jobPostResponse);
	}
}
