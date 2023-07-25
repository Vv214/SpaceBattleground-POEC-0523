package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.ClanRepository;

public class ClanService {
  private final ClanRepository clanRepository;

  @Autowired
  public ClanService(ClanRepository clanRepository) {
    this.clanRepository = clanRepository;
  }

  public void add(String clanName, String clanTag, int clanLvl) {
  }

public Object getAll() {
    return null;
}

public void update(String name, String clanName, String clanTag, int clanLvl) {
}

public Object getByName(String name) {
    return null;
}

public void delete(String name) {
}

}
