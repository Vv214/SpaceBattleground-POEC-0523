package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.templateproject.api.controller.payload.BuildingPayload;
import com.templateproject.api.entity.Building;
import com.templateproject.api.repository.BuildingRepository;

public class BuildingService {
  private final BuildingRepository buildingRepository;

  public BuildingService(BuildingRepository buildingRepository) {
    this.buildingRepository = buildingRepository;
  }

  public List<BuildingPayload> getBuildings() {
    var payload = new ArrayList<BuildingPayload>();

    List<Building> buildingList = buildingRepository.findAll();
    for (var building : buildingList) {
      var newBuilding = new BuildingPayload();
      newBuilding.setName(building.getName());
      newBuilding.setType(building.getType());
      newBuilding.setLevel(building.getLevel());
      newBuilding.setBuildingSize(building.getBuildingSize());
      newBuilding.setDescription(building.getDescription());
      newBuilding.setCoeff_prod(building.getCoeff_prod());
      newBuilding.setPriceRessource1(building.getPriceRessource1());
      newBuilding.setPriceRessource2(building.getPriceRessource2());
      newBuilding.setPriceRessource3(building.getPriceRessource3());
      newBuilding.setPriceEnergy(building.getPriceEnergy());
      newBuilding.setTimeBuilding(building.getTimeBuilding());
      payload.add(newBuilding);
    }
    return payload;
  }

  // public Building getBuilding(String name) {
  // Building building = new Building(name, );
  // return building;
  // }

  public void updateBuilding(String name, BuildingPayload building) throws Exception {
    var buildingToUpdate = buildingRepository.findByName(name);

    if (buildingToUpdate == null) {
      throw new Exception(name + " does not exist.");
    }
    if (building.getName() != null) {
      buildingToUpdate.setName(building.getName());
    }
    if (building.getType() != null) {
      buildingToUpdate.setType(building.getType());
    }
    if (building.getLevel() != 0) {
      buildingToUpdate.setLevel(building.getLevel());
    }
    if (building.getBuildingSize() != 0) {
      buildingToUpdate.setBuildingSize(building.getBuildingSize());
    }
    if (building.getDescription() != null) {
      buildingToUpdate.setDescription(building.getDescription());
    }
    if (building.getCoeff_prod() != 0) {
      buildingToUpdate.setCoeff_prod(building.getCoeff_prod());
    }
    if (building.getPriceRessource1() != 0) {
      buildingToUpdate.setPriceRessource1(building.getPriceRessource1());
    }
    if (building.getPriceRessource2() != 0) {
      buildingToUpdate.setPriceRessource2(building.getPriceRessource2());
    }
    if (building.getPriceRessource3() != 0) {
      buildingToUpdate.setPriceRessource3(building.getPriceRessource3());
    }
    if (building.getPriceEnergy() != 0) {
      buildingToUpdate.setPriceEnergy(building.getPriceEnergy());
    }
    if (building.getTimeBuilding() != 0) {
      buildingToUpdate.setTimeBuilding(building.getTimeBuilding());
    }
    buildingRepository.save(buildingToUpdate);
    /*
     * var buildingUpdated = buildingRepository.save(buildingToUpdate);
     * return new BuildingPayload(
     * buildingUpdated.getName(),
     * buildingUpdated.getType(),
     * buildingUpdated.getLevel(),
     * buildingUpdated.getBuildingSize(),
     * buildingUpdated.getDescription(),
     * buildingUpdated.getCoeff_prod(),
     * buildingUpdated.getPriceRessource1(),
     * buildingUpdated.getPriceRessource2(),
     * buildingUpdated.getPriceRessource3(),
     * buildingUpdated.getPriceEnergy(),
     * buildingUpdated.getTimeBuilding());
     */
  }

  public void add(String name, String type, int level, int buildingSize, String description,
      int coeff_prod, int priceRessource1, int priceRessource2, int priceRessource3,
      int priceEnergy, int timeBuilding) {
    // Todo check params
    var building = new Building(name, type, level, buildingSize,
        description, coeff_prod, priceRessource1, priceRessource2,
        priceRessource3, priceEnergy, timeBuilding);
    buildingRepository.save(building);
  }

}
