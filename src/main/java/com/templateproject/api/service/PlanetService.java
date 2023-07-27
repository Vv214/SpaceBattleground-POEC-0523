package com.templateproject.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Planet;
import com.templateproject.api.repository.PlanetRepository;

@Service
public class PlanetService {

  private PlanetRepository planetRepository;

  public PlanetService(PlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public List<Planet> getAllPlanets() {
    return planetRepository.findAll();
  }

  public Planet addNewPlanet(Planet planet) {
    return planetRepository.save(planet);
  }

  public ResponseEntity<String> deletePlanetById(Integer id) {
    planetRepository.deleteById(id);
    return new ResponseEntity<>("Planet successfully deleted!", HttpStatus.OK);
  }

  public Planet getPlanet(Integer id) {
    Optional<Planet> optionalPlanet = planetRepository.findById(id);
    return optionalPlanet.get();
  }

  public Planet updatePlanet(Planet planet) {
    Planet currentPlanet = planetRepository.findById(planet.getId()).get();
    currentPlanet.setName(planet.getName());
    currentPlanet.setColonised(planet.isColonised());
    currentPlanet.setPositionX(planet.getPositionX());
    currentPlanet.setPositionY(planet.getPositionY());
    currentPlanet.setPlanetSize(planet.getPlanetSize());
    Planet updatePlanet = planetRepository.save(currentPlanet);
    return updatePlanet;
  }

}