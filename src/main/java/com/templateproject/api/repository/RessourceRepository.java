package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Ressource;

public interface RessourceRepository extends JpaRepository<Ressource, Integer> {


    Ressource findByName(String name);



}

