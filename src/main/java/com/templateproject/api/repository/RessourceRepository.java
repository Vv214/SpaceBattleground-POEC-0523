package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.annotation.Ressource;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Integer> {

}
