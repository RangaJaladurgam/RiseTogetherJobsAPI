package com.risetogether.jobs.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.risetogether.jobs.api.requestdto.AdminRequest;
import com.risetogether.jobs.api.responsedto.AdminResponse;
import com.risetogether.jobs.api.service.AdminService;
import com.risetogether.jobs.api.util.AppResponseBuilder;
import com.risetogether.jobs.api.util.ResponseStructure;

@RestController
public class AdminController {
	
	private final AdminService adminService;
	private final AppResponseBuilder response;

	public AdminController(AdminService adminService, AppResponseBuilder response) {
		super();
		this.adminService = adminService;
		this.response = response;
	}
	
	@PostMapping("/admins/register")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody AdminRequest adminRequest){
		AdminResponse admin = adminService.saveAdmin(adminRequest);
		return response.success(HttpStatus.CREATED, "Admin Created Successfully", admin);
	}
	
	@GetMapping("/admins/{email}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdminByEmail(@PathVariable String email){
		AdminResponse adminResponse = adminService.findAdminByEmail(email);
		return response.success(HttpStatus.FOUND, "Admin Found Successfully", adminResponse);
	}
	
	@PutMapping("/admins/{email}")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody AdminRequest adminRequest,@PathVariable String email){
		AdminResponse adminResponse = adminService.updateAdmin(adminRequest,email);
		return response.success(HttpStatus.OK, "Admin Updated Successfully", adminResponse);
	}
	
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins(){
		List<AdminResponse> adminResponses = adminService.findAllAdmins();
		return response.success(HttpStatus.FOUND, "Admins Found Successfully",adminResponses);
	}
}
