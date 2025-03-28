package com.risetogether.jobs.api.responsedto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.risetogether.jobs.api.entity.Admin;
import com.risetogether.jobs.api.entity.Category;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class JobPostResponse {

	private String JobPostId;
	private String title;
	private String description;
	private List<String> qualifications;
	private List<Integer> passOutYears;
	private String Location;
	private String imageUrl;
	private LocalDateTime createdAt;
	private LocalDate expireDate;
	private String applyLink;

	private AdminResponse adminResponse;
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

	public List<String> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<String> qualifications) {
		this.qualifications = qualifications;
	}

	public List<Integer> getPassOutYears() {
		return passOutYears;
	}
	public void setPassOutYears(List<Integer> passOutYears) {
		this.passOutYears = passOutYears;
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
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public String getApplyLink() {
		return applyLink;
	}
	public void setApplyLink(String applyLink) {
		this.applyLink = applyLink;
	}
	public AdminResponse getAdminResponse() {
		return adminResponse;
	}
	public void setAdminResponse(AdminResponse admin) {
		this.adminResponse = admin;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}


}
