package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.ShipRepository;

public class ShipService {
  private final ShipRepository shipRepository;

  @Autowired
  public ShipService(ShipRepository shipRepository) {
    this.shipRepository = shipRepository;
  }
}
