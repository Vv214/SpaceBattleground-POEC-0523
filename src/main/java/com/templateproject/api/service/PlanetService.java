package com.templateproject.api.service;

import com.templateproject.api.repository.PlanetRepository;

public class PlanetService {
  
  private final PlanetRepository planetRepository;


  public PlanetService(PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }
}
