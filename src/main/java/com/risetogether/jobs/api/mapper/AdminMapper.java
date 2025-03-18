package com.risetogether.jobs.api.mapper;

import org.springframework.stereotype.Component;

import com.risetogether.jobs.api.entity.Admin;
import com.risetogether.jobs.api.requestdto.AdminRequest;
import com.risetogether.jobs.api.responsedto.AdminResponse;

@Component
public class AdminMapper {
	
	public Admin mapToAdmin(AdminRequest adminRequest,Admin admin) {
		admin.setEmail(adminRequest.getEmail());
		admin.setPassword(adminRequest.getPassword());
		admin.setUsername(adminRequest.getUsername());
		return admin;
	}
	
	public AdminResponse mapToAdminRespone(Admin admin) {
		AdminResponse response = new AdminResponse();
		response.setAdminId(admin.getAdminId());
		response.setEmail(admin.getEmail());
		response.setUsername(admin.getUsername());
		return response;
	}
}
