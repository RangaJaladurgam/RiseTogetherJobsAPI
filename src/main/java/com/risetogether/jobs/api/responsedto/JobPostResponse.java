package com.risetogether.jobs.api.responsedto;

import java.time.LocalDateTime;

import com.risetogether.jobs.api.entity.Admin;
import com.risetogether.jobs.api.entity.Category;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class JobPostResponse {

	private String JobPostId;
	private String title;
	private String description;
	private String Location;
	private String imageUrl;
	private LocalDateTime createdAt;
	private LocalDateTime expireDate;

	private AdminResponse admin;
	private Category category;
	public String getJobPostId() {
		return JobPostId;
	}
	public void setJobPostId(String jobPostId) {
		JobPostId = jobPostId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDateTime expireDate) {
		this.expireDate = expireDate;
	}
	public AdminResponse getAdmin() {
		return admin;
	}
	public void setAdmin(AdminResponse admin) {
		this.admin = admin;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
