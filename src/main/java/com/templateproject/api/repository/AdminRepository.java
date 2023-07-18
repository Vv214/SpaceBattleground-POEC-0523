package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
