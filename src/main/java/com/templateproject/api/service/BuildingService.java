package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.List;

//import org.apache.catalina.connector.Response;

//import org.springframework.http.ResponseEntity;

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
      newBuilding.setIronPrice(building.getIronPrice());
      newBuilding.setDiamondPrice(building.getDiamondPrice());
      newBuilding.setHydrogenPrice(building.getHydrogenPrice());
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
    if (building.getIronPrice() != 0) {
      buildingToUpdate.setIronPrice(building.getIronPrice());
    }
    if (building.getDiamondPrice() != 0) {
      buildingToUpdate.setDiamondPrice(building.getDiamondPrice());
    }
    if (building.getHydrogenPrice() != 0) {
      buildingToUpdate.setHydrogenPrice(building.getHydrogenPrice());
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
     * buildingUpdated.getironPrice(),
     * buildingUpdated.getDiamondPrice(),
     * buildingUpdated.getHydrogenPrice(),
     * buildingUpdated.getPriceEnergy(),
     * buildingUpdated.getTimeBuilding());
     */
  }

  public void add(String name, String type, int level, int buildingSize, String description,
      int coeff_prod, int ironPrice, int diamondPrice, int hydrogenPrice,
      int priceEnergy, int timeBuilding) {
    // Todo check params
    var building = new Building(name, type, level, buildingSize,
        description, coeff_prod, ironPrice, diamondPrice,
        hydrogenPrice, priceEnergy, timeBuilding);
    buildingRepository.save(building);
  }

}
