package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Technologie;

@Repository
public interface TechnologieRepository extends JpaRepository<Technologie, Integer> {
    
    public Technologie findByName(String name); 

    public Technologie findByIsDone(Boolean isDone);

    public Technologie deleteByName(String name);

     
}
