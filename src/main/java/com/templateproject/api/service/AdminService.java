package com.templateproject.api.service;


import org.springframework.stereotype.Service;

import com.templateproject.api.repository.AdminRepository;

@Service
public class AdminService {
  private final AdminRepository adminRepository;

  
  public AdminService(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

}
