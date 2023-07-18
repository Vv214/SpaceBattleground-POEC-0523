package com.templateproject.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.templateproject.api.repository.TechnologieRepository;

public class TechnologieService {
    private final TechnologieRepository technologieRepository;

    @Autowired
    public TechnologieService(TechnologieRepository technologieRepository) {
        this.technologieRepository = technologieRepository;
    }
}
