package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.ClanRepository;

public class ClanService {
  private final ClanRepository clanRepository;

  @Autowired
  public ClanService(ClanRepository clanRepository) {
    this.clanRepository = clanRepository;
  }

}
