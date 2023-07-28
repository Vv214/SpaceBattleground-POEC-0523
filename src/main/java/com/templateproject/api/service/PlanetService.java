package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.PlanetRepository;

public class PlanetService {
  
  private final PlanetRepository planetRepository;

  @Autowired
  public PlanetService(PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }
}
