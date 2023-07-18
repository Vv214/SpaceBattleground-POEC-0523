package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Vaisseau;

@Repository
public interface VaisseauRepository extends JpaRepository<Vaisseau, Integer> {

}
