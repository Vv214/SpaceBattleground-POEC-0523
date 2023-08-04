package com.templateproject.api.service;

import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Clan;
import com.templateproject.api.repository.ClanRepository;

@Service
public class ClanService {
  private final ClanRepository clanRepository;

  public ClanService(ClanRepository clanRepository) {
    this.clanRepository = clanRepository;
  }

public Object getAll() {
    return clanRepository.findAll();
}

public Clan update(Clan clan) {
  Clan currentClan = clanRepository.findByClanName(clan.getClanName());
  currentClan.setAdminNickname(clan.getAdminNickname());
  currentClan.setClanTag(clan.getClanTag());
  currentClan.setClanName(clan.getClanName());
  currentClan.setlevel(clan.getlevel());
  currentClan.setCurrentNumberPlayers(clan.getCurrentNumberPlayers());
  currentClan.setNumberMaxPlayers(clan.getNumberMaxPlayers());
  Clan updateClan = clanRepository.save(currentClan);
  return updateClan;
}

public Clan getByName(String name) {
    return clanRepository.findByClanName(name);
}

public void delete(String name) {
  Clan clan = clanRepository.findByClanName(name);
  clanRepository.delete(clan);  
//  clanRepository.deleteClanByClanName(name);
}

public void add(Clan clanToAdd) {
  Clan clan = new Clan();
  clan.setClanName(clanToAdd.getClanName());
  clan.setClanTag(clanToAdd.getClanTag());
  clanRepository.save(clan);
}
}
