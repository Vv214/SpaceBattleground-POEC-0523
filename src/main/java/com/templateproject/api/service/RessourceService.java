package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import com.templateproject.api.entity.Ressource;
import com.templateproject.api.repository.RessourceRepository;

@Service
public class RessourceService {
  private final RessourceRepository ressourceRepository;

  public RessourceService(RessourceRepository ressourceRepository) {
    this.ressourceRepository = ressourceRepository;
  }

  // CREATE
  public void add(String Name, Integer quantiy, Integer maxStock) {
    var ressource = new Ressource(Name, quantiy, maxStock);
    ressourceRepository.save(ressource);
  }

  // RESARCH ALL
  public List<HashMap<String, Object>> getAll() {
    var payload = new ArrayList<HashMap<String, Object>>();

    List<Ressource> ressourceList = ressourceRepository.findAll();
    for (var ressource : ressourceList) {
      var newRessource = new HashMap<String, Object>();
      newRessource.put("Name :", ressource.getName());
      newRessource.put("Quantity :", ressource.getQuantity());
      newRessource.put("Max Stock :", ressource.getMaxStock());
      payload.add(newRessource);
    }
    return payload;
  }

  // RESEARCH ONE
  public HashMap<String, Object> getByName(String name) {
    var ressource = new HashMap<String, Object>();
    var ressourceEntity = ressourceRepository.findByName(name);
    ressource.put("name", ressourceEntity.getName());
    ressource.put("Quantity of" + ressourceEntity.getName() + "'", ressourceEntity.getQuantity());
    ressource.put("Stock Max of " + ressourceEntity.getName() + "'", ressourceEntity.getMaxStock());
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

  // DELETE ONE
  public void delete(String name) {
    Ressource ressource = ressourceRepository.findByName(name);
    ressourceRepository.delete(ressource);
  }

}