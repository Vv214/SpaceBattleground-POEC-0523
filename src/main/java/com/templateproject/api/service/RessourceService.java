package com.templateproject.api.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.templateproject.api.controller.payload.RessourcePayload;
import com.templateproject.api.entity.Player;
import com.templateproject.api.entity.Ressource;
import com.templateproject.api.repository.RessourceRepository;

@Service
public class RessourceService {
  private final RessourceRepository ressourceRepository;

  public RessourceService(RessourceRepository ressourceRepository) {
    this.ressourceRepository = ressourceRepository;
  }

  public Object getAll(Integer playerId) {
    var ressource = ressourceRepository.findAllByPlayerId(playerId);
    return ressource;
  }
  // public Object getAll() {
  // var diamond = getByName("diamond");
  // var energy = getByName("energy");
  // var iron = getByName("iron");
  // var hydrogene = getByName("hydrogene");
  // var ressources = new HashMap<String, Object>();
  // ressources.put("diamond", diamond);
  // ressources.put("energy", energy);
  // ressources.put("iron", iron);
  // ressources.put("hydrogene", hydrogene);
  // return ressources;
  // }

  // public Object getAll(Integer playerId) {
  // var diamond = getByName("diamond", playerId);
  // var energy = getByName("energy", playerId);
  // var iron = getByName("iron", playerId);
  // var hydrogene = getByName("hydrogene", playerId);
  // var ressources = new HashMap<String, Object>();
  // ressources.put("diamond", diamond);
  // ressources.put("energy", energy);
  // ressources.put("iron", iron);
  // ressources.put("hydrogene", hydrogene);
  // return ressources;
  // }

  public Ressource update(String name, RessourcePayload ressource) {
    Ressource currentRessource = ressourceRepository.findByName(name);
    if (ressource.getName() != null) {
      currentRessource.setName(ressource.getName());
    }
    if (ressource.getQuantity() != null) {
      currentRessource.setQuantity(ressource.getQuantity());
    }
    if (ressource.getMaxStock() != null) {
      currentRessource.setMaxStock(ressource.getMaxStock());
    }
    return ressourceRepository.save(currentRessource);
  }

  // RESEARCH ONE for one player
  public HashMap<String, Object> getByName(String name, Integer playerId) {
    var ressource = new HashMap<String, Object>();
    var ressourceEntity = ressourceRepository.findOneByPlayer(name, playerId);
    if (ressourceEntity == null) {
      return ressource;
    }
    ressource.put("quantity", ressourceEntity.getQuantity());
    ressource.put("maxStock", ressourceEntity.getMaxStock());
    return ressource;
  }

  // RESEARCH ONE
  public HashMap<String, Object> getByName(String name) {
    var ressource = new HashMap<String, Object>();
    var ressourceEntity = ressourceRepository.findByName(name);
    if (ressourceEntity == null) {
      return ressource;
    }
    ressource.put("quantity", ressourceEntity.getQuantity());
    ressource.put("maxStock", ressourceEntity.getMaxStock());
    return ressource;
  }

  // UPDATE ONE
  public void update(String nameRessourceToUpdate, String name, Integer quantity, Integer maxStock) throws Exception {
    var ressource = ressourceRepository.findByName(nameRessourceToUpdate);

    if (ressource == null) {
      throw new Exception(nameRessourceToUpdate + "dosen't exist");
    }
    if (name != null) {
      ressource.setName(name);
    }
    if (quantity != 0) {
      ressource.setQuantity(quantity);
    }
    if (maxStock != 0) {
      ressource.setMaxStock(maxStock);
    }
    ressourceRepository.save(ressource);
  }

  public void delete(String name) {
    Ressource ressource = ressourceRepository.findByName(name);
    ressourceRepository.delete(ressource);
  }

  public Ressource add(Ressource ressource) {
    return ressourceRepository.save(ressource);
  }

  public Ressource findAllByPlanet(Integer planet) {
    // ressourceRepository.findAllByPlanet(planet);
    return null;
  }

}