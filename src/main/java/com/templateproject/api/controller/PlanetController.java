package com.templateproject.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.entity.Planet;
import com.templateproject.api.service.PlanetService;

@RestController
@RequestMapping(path = "/planet")
public class PlanetController {
  
  private PlanetService planetService;
  
  public PlanetController(PlanetService planetService) {
    this.planetService = planetService;
  }
  
  @PostMapping
  public Planet addNewPlanet(@RequestBody Planet planet) {
    return this.planetService.addNewPlanet(planet);
  }
  
  @GetMapping
  public List<Planet> getPlanets() {
    return this.planetService.getAllPlanets();
  }

  @GetMapping("{id}")
  public Planet getPlanet(@PathVariable("id") Integer id) {
    return this.planetService.getPlanet(id);
  }

  @PutMapping("{id}")
  public Planet updatePlanet(@PathVariable("id") Integer id, @RequestBody Planet planet) {
    planet.setId(id);
    return planetService.updatePlanet(planet);
  }


  @DeleteMapping("{id}")
  public ResponseEntity<String> deletePlanet(@PathVariable("id") Integer id) {
    return this.planetService.deletePlanetById(id);
  }
}