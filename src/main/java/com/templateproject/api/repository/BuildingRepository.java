package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Building;

public interface BuildingRepository extends JpaRepository<Building, Integer> {

}
