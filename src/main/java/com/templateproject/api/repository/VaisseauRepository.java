package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Vaisseau;

public interface VaisseauRepository extends JpaRepository<Vaisseau, Integer> {

}
