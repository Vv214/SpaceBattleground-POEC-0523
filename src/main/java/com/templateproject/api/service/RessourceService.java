package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.RessourceRepository;

public class RessourceService {
    private final RessourceRepository ressourceRepository;

    @Autowired
    public RessourceService(RessourceRepository ressourceRepository) {
        this.ressourceRepository = ressourceRepository;
    }
}
