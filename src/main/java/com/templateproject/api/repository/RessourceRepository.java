package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Planet;
import com.templateproject.api.entity.Ressource;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Integer> {
    Ressource findByName(String name);

    public Ressource deleteByName(String name);

    // @Query("SELECT r FROM Ressource r JOINT")
    // public Ressource findByPlanet(Planet name);

}