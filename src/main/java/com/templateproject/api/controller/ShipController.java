package com.templateproject.api.controller;

import java.util.List;

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
import com.templateproject.api.entity.Ship;
import com.templateproject.api.service.ShipService;

@RestController
@RequestMapping (path = "/ship")
public class ShipController {
  
  private final ShipService shipService;
  
  public ShipController(ShipService shipService) {
    this.shipService = shipService;
  }
  //CREATE
  @PostMapping
  public ResponseEntity<Payload> addNewShip(@RequestBody Ship ship) {
    var payload = new Payload();
    var ShipName = ship.getName();
    try {
      shipService.addNewShip(
        ship.getName(),
        ship.getType(),
        ship.getIronPrice(),
        ship.getDiamondPrice(),
        ship.getHydrogenPrice(),
        ship.getEnergyPrice(),
        ship.getPv(),
        ship.getDamage(),
        ship.getFuel(),
        ship.getSpeed(),
        ship.getCapacity(),
        ship.getSize(),
        ship.getQuantity(),
      );
      payload.setMessage( + " created");
      return new ResponseEntity<>(payload, HttpStatus.OK);
    } catch (Exception e) {
      payload.setMessage(e.getMessage());
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
      // TODO: handle exception
    }
    
  }
  //RESEARCH ALL
  @GetMapping ("/all")
  public List<Ship> getAllSip() {
    return ShipService.getAllShips();
  }
  //RESEARCH ONE
  @GetMapping("/{name}")
  public Ship getShip(@PathVariable("id") Integer id) {
    return ShipService.getShip(id);
  }
 //UPDATE ONE
  @PutMapping("/{name}")
  public Ship updateShip(@PathVariable("id") Integer id, @RequestBody Ship Ship) {
    Ship.setId(id);
    return ShipService.updateShip(Ship);
  }
  //DELETE ONE 
  @DeleteMapping("/{name}")
  public ResponseEntity<String> deleteShip(@PathVariable("id") Integer id) {
    return this.ShipService.deleteShipById(id);
  }
}
