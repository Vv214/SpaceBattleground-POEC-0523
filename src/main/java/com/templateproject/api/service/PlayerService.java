package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.PlanetRepository;
import com.templateproject.api.repository.PlayerRepository;

public class PlayerService {
  private final PlayerRepository playerRepository;

  @Autowired
  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }
}
