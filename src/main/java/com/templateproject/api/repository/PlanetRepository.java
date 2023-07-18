package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {

}
