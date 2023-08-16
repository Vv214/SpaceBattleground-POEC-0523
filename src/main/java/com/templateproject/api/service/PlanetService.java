package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.controller.payload.PlanetPayload;
import com.templateproject.api.entity.Building;
import com.templateproject.api.entity.Planet;
import com.templateproject.api.entity.Player;
import com.templateproject.api.repository.PlanetRepository;
import com.templateproject.api.repository.PlayerRepository;

@Service
public class PlanetService {

  private final PlanetRepository planetRepository;
  private  PlayerRepository playerRepository;

  public PlanetService(PlanetRepository planetRepository , PlayerRepository playerRepository) {
    this.planetRepository = planetRepository;
    this.playerRepository = playerRepository;
  }

  // CREATE
  public Planet addNewPlanet(String name, Integer positionX, Integer positionY,
  Integer planetSize, Integer playerId, List<Building> buildingsList) { 
    Player player = null;     
    if (playerId != null){    
      player = playerRepository.findById(playerId).get();    
    }    

    var planet = new Planet( name, positionX, positionY, planetSize, player, buildingsList);
      
    return planetRepository.save(planet);
    
  }
  public Planet addNewPlanet( String name, Integer positionX, Integer positionY, Integer planetSize, List<Building> buildingsList) {
      return this.addNewPlanet(name, positionX, positionY, planetSize,null, buildingsList);
      }

  // RESARCH ALL
  public List<PlanetPayload> getAllPlanets() {
    var planetPayload = new ArrayList<PlanetPayload>();
    List<Planet> planetList = planetRepository.findAll();
    for (var planet : planetList) {

      var newPlanet = new PlanetPayload();

      newPlanet.setName(planet.getName());
      newPlanet.setPositionX(planet.getPositionX());
      newPlanet.setPositionY(planet.getPositionY());
      newPlanet.setPlanetSize(planet.getPlanetSize());
      newPlanet.setPlayer(planet.getPlayer());
      newPlanet.setBuildingList(planet.getBuildingsList());

      planetPayload.add(newPlanet);
    }
    return planetPayload;
  }

  //RESARCH ALL PLANET by playerID 
    public List<PlanetPayload> getAllPlanets(Integer playerID) {
    var planetPayload = new ArrayList<PlanetPayload>();
    List<Planet> planetList = planetRepository.findAllByPlayerId(playerID);
    for (var planet : planetList) {

       var newPlanet = new PlanetPayload();

      newPlanet.setName(planet.getName());
      newPlanet.setPositionX(planet.getPositionX());
      newPlanet.setPositionY(planet.getPositionY());
      newPlanet.setPlanetSize(planet.getPlanetSize());
      newPlanet.setBuildingList(planet.getBuildingsList());

      planetPayload.add(newPlanet);
    }
    return planetPayload;
  }

  // RESEARCH ONE
  public HashMap<String, Object> getPlanet(String name) {
    var planet = new HashMap<String, Object>();

    var planetEntity = planetRepository.findByName(name);
    planet.put("Postion X", planetEntity.getPositionX());
    planet.put("Postion X", planetEntity.getPositionY());
    planet.put("Size Planet", planetEntity.getPlanetSize());
    planet.put ("Building List on " + planetEntity.getName() + " : ", planetEntity.getBuildingsList()); 

    return planet;
  }

  // UPDATE
  public void updatePlanet(String name, PlanetPayload planet) throws Exception {
    var planetToUpdate = planetRepository.findByName(name);

    if (planetToUpdate == null) {
      throw new Exception(name + "does not exist");
    }

    if (planet.getName() != null) {
      planetToUpdate.setName(planet.getName());
    }

    if (planet.getPositionX() != 0) {
      planetToUpdate.setPositionX(planet.getPositionX());
    }

    if (planet.getPositionY() != 0) {
      planetToUpdate.setPositionX(planet.getPositionY());
    }

    if (planet.getPlanetSize() != 0) {
      planetToUpdate.setPlanetSize(planet.getPlanetSize());

    }
    
    if (planet.getPlayer() != null ){
      planetToUpdate.setPlayer(planet.getPlayer());
    }
    if (planet.getBuildingList() != null){
      planetToUpdate.setBuildingsList(planet.getBuildingList());
    } 
  }



  // DELETE
  public ResponseEntity<String> delete(String name) {
    planetRepository.deleteByName(name);
    return new ResponseEntity<String>("Planet successfull delete", HttpStatus.OK);

  }

  

}
