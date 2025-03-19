package com.risetogether.jobs.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.risetogether.jobs.api.service.JobPostService;
import com.risetogether.jobs.api.util.AppResponseBuilder;

@RestController
public class JobPostController {
	
	private final JobPostService jobPostService;
	private final AppResponseBuilder response;
	
	public JobPostController(JobPostService jobPostService, AppResponseBuilder response) {
		super();
		this.jobPostService = jobPostService;
		this.response = response;
	}
	
	
}
