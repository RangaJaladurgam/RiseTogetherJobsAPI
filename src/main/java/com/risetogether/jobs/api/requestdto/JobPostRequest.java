package com.risetogether.jobs.api.requestdto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;

public class JobPostRequest {
	
	private String title;
	private String description;
	private List<String> qualifications;
	private List<Integer> passOutYears;
	private String location;
	private String imageUrl;
	private LocalDate expireDate;
	private String applyLink;
	
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
	
	
}
