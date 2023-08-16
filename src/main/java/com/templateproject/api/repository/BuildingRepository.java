package com.templateproject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

    public Building findByName(String name);

    public Building deleteByName(String name);

    public List<Building> findAllByPlanetId(Integer planetId) ;
}