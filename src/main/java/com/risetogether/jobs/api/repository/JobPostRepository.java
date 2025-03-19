package com.risetogether.jobs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.risetogether.jobs.api.entity.JobPost;

public interface JobPostRepository extends JpaRepository<JobPost, String>{

}
