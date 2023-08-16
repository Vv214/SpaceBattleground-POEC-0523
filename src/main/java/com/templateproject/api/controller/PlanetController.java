package com.templateproject.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.controller.payload.PlanetPayload;
import com.templateproject.api.entity.Planet;
import com.templateproject.api.service.PlanetService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/planet")
public class PlanetController {

  private final PlanetService planetService;

  public PlanetController(PlanetService planetService) {
    this.planetService = planetService;
  }

  // CREATE
  @PostMapping
  public ResponseEntity<PlanetPayload> addNewPlanet(HttpServletRequest request, @RequestBody Planet planet) {
    var payload = new PlanetPayload();
    try {
      Integer playerID = (Integer)request.getAttribute("playerID");
      System.out.println("Player ID is :" + playerID);
      
      var newPlanet = planetService.addNewPlanet( 
        planet.getName(), 
        planet.getPositionX(),
        planet.getPositionY(), 
        planet.getPlanetSize(), 
        playerID, 
        planet.getBuildingsList());
      
      payload.set( 
        newPlanet.getName() + " created", 
        newPlanet.getName(), 
        newPlanet.getPositionX(),
        newPlanet.getPositionY(), 
        newPlanet.getPlanetSize(),
        newPlanet.getPlayer(), 
        newPlanet.getBuildingsList()
        );
      
      return new ResponseEntity<>(payload, HttpStatus.CREATED);

    } catch (Exception e) {
      payload.setMessage(e.getMessage());
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  // RESEARCH ALL
  // @GetMapping("/planets")
  // public ResponseEntity<Payload> getPlanets() {
  //   var payload = new Payload();
  //   try {
  //     payload.setData(planetService.getAllPlanets());
  //     payload.setMessage("Get all Planets");
  //     return new ResponseEntity<>(payload, HttpStatus.OK);
  //   } catch (Exception e) {
  //     payload.setMessage(e.getMessage());
  //     payload.setData(null);
  //     return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);

  //   }

  // }

  //RESEARCH ALL PLANET by playerID - On ServicePlanet
  



  @GetMapping("/planets")
  public ResponseEntity<Payload> getPlanets(HttpServletRequest request) {
    
     var playerID = (Integer)request.getAttribute("playerID");

    var payload = new Payload();
    
    try {
      payload.setData(planetService.getAllPlanets(playerID));
      payload.setMessage("Get all Planets");
      return new ResponseEntity<>(payload, HttpStatus.OK);

    } catch (Exception e) {

      payload.setMessage(e.getMessage());
      payload.setData(null);
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);

    }

  }

  // RESEACH ONE
  @GetMapping("/{name}")
  public ResponseEntity<Payload> getPlanetByName(@PathVariable String name) {

    var payload = new Payload();
    try {
      var planet = planetService.getPlanet(name);

      payload.setMessage("Get Planet by Name'" + name + "'");
      payload.setData(planet);

      return new ResponseEntity<>(payload, HttpStatus.OK);

    } catch (Exception e) {
      payload.setMessage(e.getMessage());
      payload.setData(null);
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // UPDATE ONE
  @PutMapping("/{name}")
  public ResponseEntity<PlanetPayload> updatePlanet(@PathVariable String name, @RequestBody Planet planet) {
    var payload = new PlanetPayload();
    try {

      payload.setName(planet.getName());
      payload.setPositionX(planet.getPositionX());
      payload.setPositionY(planet.getPositionY());
      payload.setPlanetSize(planet.getPlanetSize());

      planetService.updatePlanet(name, payload);
      payload.setMessage("Planet UpDate");
      return new ResponseEntity<>(payload, HttpStatus.OK);
    } catch (Exception e) {
      payload.setMessage(e.getMessage());
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  // DELETE ONE
  @DeleteMapping("/{name}")
  public ResponseEntity<String> deletePlanet(@PathVariable String name) {
    return this.planetService.delete(name);
  }
}