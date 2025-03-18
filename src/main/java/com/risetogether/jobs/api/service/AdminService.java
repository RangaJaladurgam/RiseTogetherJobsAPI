package com.risetogether.jobs.api.service;

import org.springframework.stereotype.Service;

import com.risetogether.jobs.api.entity.Admin;
import com.risetogether.jobs.api.mapper.AdminMapper;
import com.risetogether.jobs.api.repository.AdminRepository;
import com.risetogether.jobs.api.requestdto.AdminRequest;
import com.risetogether.jobs.api.responsedto.AdminResponse;

@Service
public class AdminService {
	
	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper; 
	
	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
	}

	public AdminResponse saveAdmin(AdminRequest adminRequest) {
		Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
		admin = adminRepository.save(admin);
		return adminMapper.mapToAdminRespone(admin);
	}

	public AdminResponse findAdminByEmail(String email) {
		AdminResponse admin = adminRepository.findAdminByEmail(email)
											 .map(adminMapper::mapToAdminRespone)
											 .orElseThrow();
		return null;
	}
	
}
