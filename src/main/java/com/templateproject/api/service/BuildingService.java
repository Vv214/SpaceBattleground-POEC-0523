package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.templateproject.api.controller.payload.BuildingPayload;
import com.templateproject.api.entity.Building;
import com.templateproject.api.repository.BuildingRepository;

public class BuildingService {
  private final BuildingRepository buildingRepository;

  public BuildingService(BuildingRepository buildingRepository) {
    this.buildingRepository = buildingRepository;
  }

  // CREATE
  public void add(String name,
      String type,
      Integer level,
      String description,
      Integer coeff_prod,
      Integer ironPrice,
      Integer diamondPrice,
      Integer hydrogenPrice,
      Integer energyPrice,
      Date timeBuilding,
      Date timeToStart) {
    // Todo check params
    var building = new Building(name, type, level, description, coeff_prod,
        ironPrice, diamondPrice, hydrogenPrice, energyPrice,
        timeBuilding, timeToStart);

    buildingRepository.save(building);

  }

  // RESEARCH ALL
  public List<BuildingPayload> getBuildings() {
    var payload = new ArrayList<BuildingPayload>();

    List<Building> buildingList = buildingRepository.findAll();
    for (var building : buildingList) {
      var newBuilding = new BuildingPayload();
      newBuilding.setName(building.getName());

      newBuilding.setType(building.getType());

      newBuilding.setLevel(building.getLevel());
      newBuilding.setDescription(building.getDescription());
      newBuilding.setCoeff_prod(building.getCoeff_prod());

      newBuilding.setIronPrice(building.getIronPrice());
      newBuilding.setDiamondPrice(building.getDiamondPrice());
      newBuilding.setHydrogenPrice(building.getHydrogenPrice());
      newBuilding.setEnergyPrice(building.getEnergyPrice());

      newBuilding.setTimeBuilding(building.getTimeBuilding());
      newBuilding.setTimeToStart(building.getTimeToStart());

      payload.add(newBuilding);

    }
    return payload;
  }

  // RESEARCH ONE
  public HashMap<String, Object> getBuilding(String name) {
    var building = new HashMap<String, Object>();

    var buildingEntity = buildingRepository.findByName(name);
    building.put("Name: ", buildingEntity.getName());
    building.put("type: ", buildingEntity.getType());
    building.put("Level: ", buildingEntity.getLevel());
    building.put("Description: ", buildingEntity.getDescription());
    building.put("Production Coefficient: ", buildingEntity.getCoeff_prod());
    building.put("Iron Price: ", buildingEntity.getIronPrice());
    building.put("Diamond Price: ", buildingEntity.getDiamondPrice());
    building.put("Hydrogen Price: ", buildingEntity.getHydrogenPrice());
    building.put("Energy Price: ", buildingEntity.getEnergyPrice());
    building.put("Time to Build: ", buildingEntity.getTimeBuilding());
    building.put("Date to Start: ", buildingEntity.getTimeToStart());

    return building;
  }

  // UPDATE ONE
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
    if (building.getEnergyPrice() != 0) {
      buildingToUpdate.setEnergyPrice(building.getEnergyPrice());
    }
    if (building.getTimeBuilding() != null) {
      buildingToUpdate.setTimeBuilding(building.getTimeBuilding());
    }
    if (building.getTimeBuilding() != null) {
      buildingToUpdate.setTimeToStart(building.getTimeToStart());
    }
    buildingRepository.save(buildingToUpdate);

  }

  // DELETE ONE
  public ResponseEntity<String> deleteBuilding(String name) {
    buildingRepository.deleteByName(name);
    return new ResponseEntity<String>("Player successfully deleted!", HttpStatus.OK);
  }
}
