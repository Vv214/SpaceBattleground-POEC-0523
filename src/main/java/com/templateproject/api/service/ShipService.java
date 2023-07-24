package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.ShipRepository;

public class ShipService {
  private final ShipRepository shipRepository;

  @Autowired //est une annoation déprécier, il n'es tlus nécéssaire de le declarer à partir du moment ou l'instance est instancié via un constructeur. 
  public ShipService(ShipRepository shipRepository) {
    this.shipRepository = shipRepository;
  }
}
