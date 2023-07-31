package com.templateproject.api.controller;

import java.util.List;

import org.apache.coyote.Response;
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

@RestController
@RequestMapping(path = "/planet")
public class PlanetController {
  
  private final PlanetService planetService;
  
  public PlanetController(PlanetService planetService) {
    this.planetService = planetService;
  }
  
  //CREATE
  @PostMapping ("/planet") 
  public ResponseEntity<PlanetPayload>addNewPlanet(@RequestBody Planet planet) {
    var payload = new PlanetPayload();
    try {

      PlanetService.addNewPlanet(
        planet.getName(),
        planet.isColonised(), 
        planet.getPlanetSize(),
        planet.getPositionX(),
        planet.getPositionY()
      );

      payload.setMessage(planet.getName() + "created");
      return new ResponseEntity<>(payload,HttpStatus.CREATED);
    
    } catch (Exception e) {
        payload.setMessage(e.getMessage())
        return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR)
      }
      
    }
  

  //RESEARCH ALL
  @GetMapping ("/planets")
  public ResponseEntity<Payload> getPlanets() {
    var payload = new Payload(); 
    try {
      payload.setData(planetService.getAllPlanets());
      payload.setMessage("Get all Planets");
      return new ResponseEntity<>(payload,HttpStatus.OK);
    } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);

    }
  
  }
//RESEACH ONE
  @GetMapping("/planet/{name}") 
  public ResponseEntity<Payload> getPlanetByName(@PathVariable String name) {
    
    var payload = new Payload();
    try {
      var planet = planetService.getPlanet(name); // ERROR Method incomplet

      payload.setMessage("Get Planet by Name'"+ name +"'");
      payload.setData(planet);

      return new ResponseEntity<>(payload, HttpStatus.OK);

    } catch (Exception e) {
       payload.setMessage(e.getMessage());
       payload.setData(null);
       return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

// UPDATE ONE
  @PutMapping("/planet/{name}")
  public ResponseEntity<PlanetPayload> updatePlanet(@PathVariable String name, @RequestBody Planet planet) {
    var payload = new Payload();
    try {
      planetService.updatePlanet(name, 
        planet.getName(), 
        planet.isColonised(), 
        planet.getPositionX(), 
        planet.getPositionY(), 
        planet.getPlanetSize());
      payload.setMessage("Planet UpDate");
      return new ResponseEntity<>(payload,HttpStatus.OK);
    } catch (Exception e) {
        payload.setMessage(e.getMessage());
        return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return planetService.updatePlanet(planet);
  }

//DELETE ONE
  @DeleteMapping("{id}")
  public ResponseEntity<String> deletePlanet(@PathVariable("id") Integer id) {
    return this.planetService.deletePlanetById(id);
  }
}