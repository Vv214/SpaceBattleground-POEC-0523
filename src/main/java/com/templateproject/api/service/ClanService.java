package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.templateproject.api.controller.payload.ClanPayload;
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
    // clanRepository.deleteClanByClanName(name);
  }

  public Clan add(Clan clanToAdd) {
    Clan clan = new Clan();
    clan.setClanName(clanToAdd.getClanName());
    clan.setClanTag(clanToAdd.getClanTag());
    clan.setAdminNickname(clanToAdd.getAdminNickname());
    System.out.println("clan dans service" + clan);
    return clanRepository.save(clan);
  }

  // CREATE ONE
  public void createClan(String name, String tag, String adminNickname) {
    var clan = new Clan(name, tag, adminNickname);
    clanRepository.save(clan);
  }

  // RESEARCH ALL
  public List<ClanPayload> getClans() {
    var clanPayload = new ArrayList<ClanPayload>();
    List<Clan> clanList = clanRepository.findAll();
    for (var clan : clanList) {

      var newClan = new ClanPayload();
      newClan.setName(clan.getClanName());
      newClan.setTag(clan.getClanTag());
      newClan.setAdminNickname(clan.getAdminNickname());
      newClan.setCurrentNumberPlayers(clan.getCurrentNumberPlayers());
      newClan.setNumberMaxPlayers(clan.getNumberMaxPlayers());

      clanPayload.add(newClan);
    }
    return clanPayload;
  }

  // RESEARCH ONE
  public HashMap<String, Object> getClanByName(String name) {
    var clan = new HashMap<String, Object>();

    var clanEntity = clanRepository.findByClanName(name);
    clan.put("name", clanEntity.getClanName());
    clan.put("tag", clanEntity.getClanTag());
    clan.put("adminNickname", clanEntity.getAdminNickname());
    clan.put("currentNumberPlayers", clanEntity.getCurrentNumberPlayers());
    clan.put("numberMaxPlayers", clanEntity.getNumberMaxPlayers());

    return clan;
  }
}