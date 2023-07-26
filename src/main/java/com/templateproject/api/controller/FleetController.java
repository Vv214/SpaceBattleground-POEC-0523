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

import com.templateproject.api.entity.Fleet;
import com.templateproject.api.service.FleetService;

@RestController
@RequestMapping(path = "/ships")
public class FleetController {

  private final FleetService FleetService;

  public FleetController(FleetService FleetService) {
    this.FleetService = FleetService;
  }

  @GetMapping
  public List<Fleet> getAllSip() {
    return FleetService.getAllShips();
  }

  @GetMapping("{id}")
  public Fleet getShip(@PathVariable("id") Integer id) {
    return FleetService.getShip(id);
  }

  @PostMapping
  public Fleet addNewShip(@RequestBody Fleet Fleet) {
    return FleetService.createShip(Fleet);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteShip(@PathVariable("id") Integer id) {
    return this.FleetService.deleteShipById(id);
  }

  @PutMapping("{id}")
  public Fleet updateShip(@PathVariable("id") Integer id, @RequestBody Fleet Fleet) {
    Fleet.setId(id);
    return FleetService.updateShip(Fleet);
  }
}
