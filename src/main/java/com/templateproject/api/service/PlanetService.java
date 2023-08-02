package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.controller.payload.PlanetPayload;
import com.templateproject.api.entity.Planet;
import com.templateproject.api.repository.PlanetRepository;

@Service
public class PlanetService {

  private final PlanetRepository planetRepository;

  public PlanetService(PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  // CREATE
  public void addNewPlanet(
      String name,
      boolean isColonised,
      Integer positionX,
      Integer positionY,
      Integer planetSize) {
    var planet = new Planet(
        name,
        isColonised,
        positionX,
        positionY,
        planetSize);
    planetRepository.save(planet);
  }

  // RESARCH ALL
  public List<PlanetPayload> getAllPlanets() {
    var planetPayload = new ArrayList<PlanetPayload>();
    List<Planet> planetList = planetRepository.findAll();
    for (var planet : planetList) {

      var newPlanet = new PlanetPayload();

      newPlanet.setName(planet.getName());
      newPlanet.setColonised(planet.isColonised());
      newPlanet.setPositionX(planet.getPositionX());
      newPlanet.setPositionY(planet.getPositionY());
      newPlanet.setPlanetSize(planet.getPlanetSize());

      planetPayload.add(newPlanet);
    }
    return planetPayload;
  }

  // RESEARCH ONE
  public HashMap<String, Object> getPlanet(String name) {
    var planet = new HashMap<String, Object>();

    var planetEntity = planetRepository.findByName(name);
    planet.put("Colonise Status: ", planetEntity.isColonised());
    planet.put("Postion X", planetEntity.getPositionX());
    planet.put("Postion X", planetEntity.getPositionY());
    planet.put("Size Planet", planetEntity.getPlanetSize());

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

    planetToUpdate.setColonised(planet.isColonised());

    if (planet.getPositionX() != 0) {
      planetToUpdate.setPositionX(planet.getPositionX());
    }
    if (planet.getPositionY() != 0) {
      planetToUpdate.setPositionX(planet.getPositionY());
    }
    if (planet.getPlanetSize() != 0) {
      planetToUpdate.setPlanetSize(planet.getPlanetSize());

    }

  }

  // DELETE
  public ResponseEntity<String> delete(String name) {
    planetRepository.deleteByName(name);
    return new ResponseEntity<String>("Planet successfull delete", HttpStatus.OK);

  }

}
