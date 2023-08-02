package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {
    public Planet findByName(String name);
    public Planet deleteByName(String name);
    public Planet findByIsColonised(boolean isColonised);
    public Planet findByPositionX(Integer X);
    public Planet findByPositionY(Integer Y);

}
