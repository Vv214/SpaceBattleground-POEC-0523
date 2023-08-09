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
import com.templateproject.api.entity.Ship;
import com.templateproject.api.service.ShipService;

@RestController
@RequestMapping(path = "/ship")
public class ShipController {

  private final ShipService shipService;

  public ShipController(ShipService shipService) {
    this.shipService = shipService;
  }

  // CREATE
  @PostMapping
  public ResponseEntity<Payload> addNewShip(@RequestBody Ship ship) {
    var payload = new Payload();
    var ShipName = ship.getName();
    try {
      shipService.createShip(
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
          ship.getQuantity());
      payload.setMessage(ShipName + " created");
      return new ResponseEntity<>(payload, HttpStatus.OK);
    } catch (Exception e) {
      payload.setMessage(e.getMessage());
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
      // TODO: handle exception
    }

  }

  // RESEARCH ALL
  @GetMapping("/ship")
  public ResponseEntity<Payload> getAllShip() {
    var payload = new Payload();
    try {

      payload.setData(shipService.getAllShips());
      payload.setMessage("Get All Ships :");
      payload.setData(payload);
      return new ResponseEntity<>(payload, HttpStatus.OK);
    } catch (Exception e) {
      payload.setMessage(e.getMessage());
      payload.setData(null);
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
      // TODO: handle exception
    }
  }

  // RESEARCH ONE
  @GetMapping("/{name}")
  public ResponseEntity<Payload> getShipByName(@PathVariable String name) {
    var payload = new Payload();
    try {
      var ship = shipService.getShipByName(name);
      payload.setMessage("Get Ship By Name :" + name + "'");
      payload.setData(ship);
      return new ResponseEntity<>(payload, HttpStatus.OK);

    } catch (Exception e) {

      payload.setMessage(e.getMessage());
      payload.setData(null);
      return new ResponseEntity<>(payload, HttpStatus.OK);

      // TODO: handle exception
    }
  }

  // UPDATE ONE
  @PutMapping("/{name}")
  public ResponseEntity<Payload> updateShip(@PathVariable String name, @RequestBody Ship ship) {
    var payload = new Payload();
    try {
      shipService.updateShip(
          name,
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
          ship.getQuantity());
      payload.setMessage("Ship Update");
      return new ResponseEntity<>(payload, HttpStatus.OK);
    } catch (Exception e) {
      payload.setMessage(e.getMessage());
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
      // TODO: handle exception
    }
  }

  // DELETE ONE
  @DeleteMapping("/{name}")
  public ResponseEntity<Payload> deleteShip(@PathVariable String name) {
    var payload = new Payload();
    try {
      shipService.deleteShipByName(name);
      payload.setMessage("The " + name + "class deleted");
      return new ResponseEntity<>(payload, HttpStatus.OK);
    } catch (Exception e) {
      payload.setMessage(e.getMessage());
      return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}