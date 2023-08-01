package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Clan;

public interface ClanRepository extends JpaRepository<Clan, Integer> {

    Clan findByClanName(String name);
    Clan deleteClanByClanName(String name);
    Clan findByLevel(Integer level);


}
