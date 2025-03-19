package com.risetogether.jobs.api.service;

import org.springframework.stereotype.Service;

import com.risetogether.jobs.api.mapper.JobPostMapper;
import com.risetogether.jobs.api.repository.JobPostRepository;

@Service
public class JobPostService {
	
	private final JobPostRepository jobPostRepository;
	private final JobPostMapper jobPostMapper;
	
	public JobPostService(JobPostRepository jobPostRepository, JobPostMapper jobPostMapper) {
		super();
		this.jobPostRepository = jobPostRepository;
		this.jobPostMapper = jobPostMapper;
	}
	
	
}
