package com.templateproject.api.service;

import org.springframework.stereotype.Service;

import com.templateproject.api.repository.AdminRepository;

@Service
public class AdminService {

  private final AdminRepository adminRepository;

  public AdminService(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  // CREATE
  public void addAdmin() {

  }

  // RESEARCH ALL
  public void getAllAdmins() {

  }

  // RESARCH ONE
  public void getAdmin() {

  }

  // UPDATE ONE
  public void updateAdmin() {

  }

  // DELETE ONE
  public void deleteAdmin() {

  }

}
