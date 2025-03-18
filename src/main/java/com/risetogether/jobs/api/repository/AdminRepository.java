package com.risetogether.jobs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.risetogether.jobs.api.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{

}
