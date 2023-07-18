package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Flotte;

@Repository
public interface FlotteRepository extends JpaRepository<Flotte, Integer> {

}
