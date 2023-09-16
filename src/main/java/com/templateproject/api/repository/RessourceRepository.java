package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.data.repository.query.Param;
=======
>>>>>>> 23745ae680475693279320431b3cbecacc455b6c
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Planet;
import com.templateproject.api.entity.Ressource;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Integer> {
    public Ressource findByName(String name);

    // Ressource findByPlayerIdAndRessource(Integer playerId, String name);

    public Ressource deleteByName(String name);

    // @Query("SELECT r FROM Ressource r JOINT")
    // public Ressource findByPlanet(Planet name);

<<<<<<< HEAD
    // public Ressource findOneByPlayer(String name, Integer playerId);

    public List<Ressource> findAllByPlayerId(Integer playerId);

    // public Ressource findOneRessourceByPlayerId(String name, Integer playerId);

    @Query("SELECT r FROM Ressource r WHERE r.name = :name AND r.player.id = :player_id")
    Ressource findRessourceByNomAndPlayerId(@Param("name") String name, @Param("player_id") Integer player_id);
=======
>>>>>>> 23745ae680475693279320431b3cbecacc455b6c
}