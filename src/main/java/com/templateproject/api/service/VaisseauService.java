package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.VaisseauRepository;

public class VaisseauService {
  private final VaisseauRepository vaisseauRepository;

  @Autowired
  public VaisseauService(VaisseauRepository vaisseauRepository) {
    this.vaisseauRepository = vaisseauRepository;
  }
}
