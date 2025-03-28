package com.risetogether.jobs.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.risetogether.jobs.api.config.GenerateCustomId;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobPost {
	
	@Id
	@GenerateCustomId
	private String jobPostId;
	private String title;
	@Column(columnDefinition = "Text")
	private String description;
	@ElementCollection
	@CollectionTable(name = "job_post_passout_years", joinColumns = @JoinColumn(name = "job_post_id"))
	@Column(name = "year")
	private List<Integer> passOutYears;
	@ElementCollection
	@CollectionTable(name = "job_post_qualification", joinColumns = @JoinColumn(name = "job_post_id"))
	@Column(name = "year")
	private List<String> qualifications;
	private String location;
	private String imageUrl;
	private LocalDateTime createdAt;
	private LocalDate expireDate;
	private String applyLink;
	
	@ManyToOne
	private Admin admin;
	
	@ManyToOne
	private Category category;

	public String getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(String jobPostId) {
		this.jobPostId = jobPostId;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Integer> getPassOutYears() {
		return passOutYears;
	}

	public void setPassOutYears(List<Integer> passOutYears) {
		this.passOutYears = passOutYears;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
