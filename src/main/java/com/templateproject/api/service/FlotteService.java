package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.FlotteRepository;

public class FlotteService {
  private final FlotteRepository flotteRepository;

  @Autowired
  public FlotteService(FlotteRepository flotteRepository) {
    this.flotteRepository = flotteRepository;
  }
}
