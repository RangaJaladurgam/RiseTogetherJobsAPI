package com.risetogether.jobs.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.risetogether.jobs.api.entity.Admin;
import com.risetogether.jobs.api.responsedto.AdminResponse;

public interface AdminRepository extends JpaRepository<Admin, String>{

	Optional<Admin> findAdminByEmail(String email);

}
