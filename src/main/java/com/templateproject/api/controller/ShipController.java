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

import com.templateproject.api.entity.Ship;
import com.templateproject.api.service.ShipService;

@RestController
@RequestMapping(path = "/ships")
public class ShipController {

  private final ShipService ShipService;

  public ShipController(ShipService ShipService) {
    this.ShipService = ShipService;
  }

  @GetMapping
  public List<Ship> getAllSip() {
    return ShipService.getAllShips();
  }

  @GetMapping("{id}")
  public Ship getShip(@PathVariable("id") Integer id) {
    return ShipService.getShip(id);
  }

  @PostMapping
  public Ship addNewShip(@RequestBody Ship Ship) {
    return ShipService.createShip(Ship);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteShip(@PathVariable("id") Integer id) {
    return this.ShipService.deleteShipById(id);
  }

  @PutMapping("{id}")
  public Ship updateShip(@PathVariable("id") Integer id, @RequestBody Ship Ship) {
    Ship.setId(id);
    return ShipService.updateShip(Ship);
  }
}
