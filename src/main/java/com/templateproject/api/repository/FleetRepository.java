package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Fleet;
import com.templateproject.api.entity.Planet;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Integer> {
    public Fleet findByName(String name);
    public Fleet deleteByName(String name);
    public Planet findByPower(Integer power);
}
