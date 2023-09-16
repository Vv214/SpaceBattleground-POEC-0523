package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Planet;
import com.templateproject.api.entity.Ressource;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Integer> {
    public Ressource findByName(String name);

    public Ressource deleteByName(String name);

    public List<Ressource> findAllByPlayerId(Integer playerId);

    @Query("SELECT r FROM Ressource r WHERE r.name = :name AND r.player.id = :player_id")
    Ressource findRessourceByNomAndPlayerId(@Param("name") String name, @Param("player_id") Integer player_id);
}