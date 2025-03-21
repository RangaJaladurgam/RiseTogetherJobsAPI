package com.risetogether.jobs.api.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.risetogether.jobs.api.entity.Admin;
import com.risetogether.jobs.api.exception.AdminNotFoundByEmailException;
import com.risetogether.jobs.api.exception.NoAdminsFoundException;
import com.risetogether.jobs.api.mapper.AdminMapper;
import com.risetogether.jobs.api.repository.AdminRepository;
import com.risetogether.jobs.api.requestdto.AdminRequest;
import com.risetogether.jobs.api.responsedto.AdminResponse;

@Service
public class AdminService {

	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;
	private final PasswordEncoder passwordEncoder;

	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper, PasswordEncoder passwordEncoder) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public AdminResponse saveAdmin(AdminRequest adminRequest) {
		Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin = adminRepository.save(admin);
		return adminMapper.mapToAdminRespone(admin);
	}

	public AdminResponse findAdminByEmail(String email) {
		return adminRepository.findAdminByEmail(email)
				.map(adminMapper::mapToAdminRespone)
				.orElseThrow(()-> new AdminNotFoundByEmailException("Failed to find Admin by Email"));
	}

	public AdminResponse updateAdmin(AdminRequest adminRequest, String email) {
		return adminRepository.findAdminByEmail(email)
				.map((exAdmin)-> {
					exAdmin = adminMapper.mapToAdmin(adminRequest, exAdmin);
					exAdmin.setPassword(passwordEncoder.encode(exAdmin.getPassword()));
					return adminRepository.save(exAdmin);
				})
				.map(adminMapper::mapToAdminRespone)
				.orElseThrow(()-> new AdminNotFoundByEmailException("Failed to Update Admin by Email"));
	}

	public List<AdminResponse> findAllAdmins() {
		List<AdminResponse> adminResponses = adminRepository.findAll()
 														   .stream()
														   .map(adminMapper::mapToAdminRespone)
														   .toList();
		if(adminResponses.isEmpty())
			throw new NoAdminsFoundException("Failed to Find All Admins");
		return adminResponses;
	}

}
