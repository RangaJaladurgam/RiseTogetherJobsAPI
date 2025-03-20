package com.risetogether.jobs.api.entity;

import com.risetogether.jobs.api.config.GenerateCustomId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@GenerateCustomId
	private String adminId;
	private String username;
	private String email;
	private String password;
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
