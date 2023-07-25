package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Clan;


@Repository
public interface ClanRepository extends JpaRepository<Clan, Integer> {

   public  Clan  findByClanName(String clanName);
   public  Clan  findByClanTag(String clanTag);

}
