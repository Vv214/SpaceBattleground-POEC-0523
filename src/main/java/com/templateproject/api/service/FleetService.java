package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.FleetRepository;

public class FleetService {
  private final FleetRepository fleetRepository;

  @Autowired
  public FleetService(FleetRepository fleetRepository) {
    this.fleetRepository = fleetRepository;
  }
}
