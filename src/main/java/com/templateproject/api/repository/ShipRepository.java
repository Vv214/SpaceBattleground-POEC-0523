package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Integer> {

}
