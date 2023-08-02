package com.templateproject.api.service;

import org.springframework.stereotype.Service;
import com.templateproject.api.entity.Ressource;
import com.templateproject.api.repository.RessourceRepository;

@Service
public class RessourceService {
  private final RessourceRepository ressourceRepository;

  public RessourceService(RessourceRepository ressourceRepository) {
    this.ressourceRepository = ressourceRepository;
  }

  public Object getAll() {
    return ressourceRepository.findAll();
  }

  public Ressource update(String name, Ressource ressource) {
    Ressource currentRessource = ressourceRepository.findByName(name);
    currentRessource.setName(ressource.getName());
    currentRessource.setQuantity(ressource.getQuantity());
    currentRessource.setMaxStock(ressource.getMaxStock());
    return ressourceRepository.save(currentRessource);
  }

  public Ressource getByName(String name) {
    return ressourceRepository.findByName(name);
  }

  public void delete(String name) {
    Ressource ressource = ressourceRepository.findByName(name);
    ressourceRepository.delete(ressource);
  }

  public Ressource add(Ressource ressource) {
    return ressourceRepository.save(ressource);
  }

}