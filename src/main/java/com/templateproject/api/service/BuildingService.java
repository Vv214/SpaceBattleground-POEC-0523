package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.controller.payload.BuildingPayload;
import com.templateproject.api.entity.Building;
import com.templateproject.api.entity.Planet;
import com.templateproject.api.repository.BuildingRepository;
import com.templateproject.api.repository.PlanetRepository;

@Service
public class BuildingService {
  private final BuildingRepository buildingRepository;
  private final PlanetRepository planetRepository;

  public BuildingService(BuildingRepository buildingRepository, PlanetRepository planetRepository) {

    this.buildingRepository = buildingRepository;
    this.planetRepository = planetRepository;
  }

  public Object getAll() {
    var laboratory = getBuilding("Laboratoire");
    var robotFactory = getBuilding("Usine de robots");
    var shipyard = getBuilding("Chantier spatial");
    var terraformer = getBuilding("Terraformeur");
    var ironMine = getBuilding("Mine de fer");
    var diamondMine = getBuilding("Mine de Diamant");
    var hydrogenMine = getBuilding("Extracteur d'Hydrogène");
    var energyMine = getBuilding("Centrale électrique");
    var ironStockage = getBuilding("Hangar de fer");
    var hydrogenStockage = getBuilding("Hangar d'hydrogene");
    var diamondStockage = getBuilding("Hangar de diamants");
    var drillingMachine = getBuilding("Foreuse");

    var buildings = new HashMap<String, Object>();
    buildings.put("laboratory", laboratory);
    buildings.put("robotFactory", robotFactory);
    buildings.put("shipyard", shipyard);
    buildings.put("terraformer", terraformer);
    buildings.put("ironMine", ironMine);
    buildings.put("diamondMine", diamondMine);
    buildings.put("hydrogenMine", hydrogenMine);
    buildings.put("energyMine", energyMine);
    buildings.put("ironStockage", ironStockage);
    buildings.put("hydrogenStockage", hydrogenStockage);
    buildings.put("diamondStockage", diamondStockage);
    buildings.put("drillingMachine", drillingMachine);
    System.out.println(buildings + " building back");
    return buildings;
  }

  // CREATE

  public void add(
      String name, String type, Integer level,
      String description, Integer coeff_prod, Integer ironPrice,
      Integer diamondPrice, Integer hydrogenPrice, Integer energyPrice,
      Date timeBuilding, Date timeToStart, Integer planetId) {
    // Todo check params
    Planet planet = null;
    if (planetId != null) {
      planet = planetRepository.findById(planetId).get();
    }

    var building = new Building(name, type, level, description, coeff_prod,
        ironPrice, diamondPrice, hydrogenPrice, energyPrice, timeBuilding,
        timeToStart, planet);

    buildingRepository.save(building);

  }

  public void add(Building building) {

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
      newBuilding.setPlanet(building.getPlanet());

      payload.add(newBuilding);

    }
    return payload;
  }

  // RESARCH ALL BUILDING by planetID
  public List<BuildingPayload> getAllBuildingsOnThisPlanet(Integer planetId) {
    var buildingPayload = new ArrayList<BuildingPayload>();
    List<Building> buildingsList = buildingRepository.findAllByPlanetId(planetId);
    for (var building : buildingsList) {
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
      newBuilding.setPlanet(building.getPlanet());

      buildingPayload.add(newBuilding);

    }
    return buildingPayload;
  }

  // RESEARCH ONE

  public HashMap<String, Object> getBuilding(String name) {
    var building = new HashMap<String, Object>();

    var buildingEntity = buildingRepository.findByName(name);
    if (buildingEntity == null) {
      return building;
    }
    building.put("name", buildingEntity.getName());
    building.put("type", buildingEntity.getType());
    building.put("level", buildingEntity.getLevel());
    building.put("description", buildingEntity.getDescription());
    building.put("coeffProd", buildingEntity.getCoeff_prod());
    building.put("ironPrice", buildingEntity.getIronPrice());
    building.put("diamondPrice", buildingEntity.getDiamondPrice());
    building.put("hydrogenPrice", buildingEntity.getHydrogenPrice());
    building.put("energyPrice", buildingEntity.getEnergyPrice());
    building.put("buildTime", buildingEntity.getTimeBuilding());
    building.put("dateStart", buildingEntity.getTimeToStart());

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
    if (building.getLevel() != null) {
      buildingToUpdate.setLevel(building.getLevel());
    }
    if (building.getDescription() != null) {
      buildingToUpdate.setDescription(building.getDescription());
    }
    if (building.getCoeff_prod() != null) {
      buildingToUpdate.setCoeff_prod(building.getCoeff_prod());
    }
    if (building.getIronPrice() != null) {
      buildingToUpdate.setIronPrice(building.getIronPrice());
    }
    if (building.getDiamondPrice() != null) {
      buildingToUpdate.setDiamondPrice(building.getDiamondPrice());
    }
    if (building.getHydrogenPrice() != null) {
      buildingToUpdate.setHydrogenPrice(building.getHydrogenPrice());
    }
    if (building.getEnergyPrice() != null) {
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
    return new ResponseEntity<String>("Building successfully deleted!",
        HttpStatus.OK);
  }

  // level up
  public Building levelUp(Integer buildingId) {
    var buildingToUpdate = buildingRepository.findById(buildingId).get();
    buildingToUpdate.setLevel(buildingToUpdate.getLevel() + 1);
    return buildingRepository.save(buildingToUpdate);

  }
}