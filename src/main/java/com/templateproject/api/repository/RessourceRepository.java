package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Ressource;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Integer> {
    public Ressource findByName(String name);

    // Ressource findByPlayerIdAndRessource(Integer playerId, String name);

    public Ressource deleteByName(String name);

    // public Ressource findOneByPlayer(String name, Integer playerId);

    public List<Ressource> findAllByPlayerId(Integer playerId);

    // public Ressource findOneRessourceByPlayerId(String name, Integer playerId);
}