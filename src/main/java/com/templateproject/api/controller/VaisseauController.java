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

import com.templateproject.api.entity.Vaisseau;
import com.templateproject.api.service.VaisseauService;

@RestController
@RequestMapping(path = "/ships")
public class VaisseauController {

  private final VaisseauService vaisseauService;

  public VaisseauController(VaisseauService vaisseauService) {
    this.vaisseauService = vaisseauService;
  }

  @GetMapping
  public List<Vaisseau> getAllSip() {
    return vaisseauService.getAllShips();
  }

  @GetMapping("{id}")
  public Vaisseau getShip(@PathVariable("id") Integer id) {
    return vaisseauService.getShip(id);
  }

  @PostMapping
  public Vaisseau addNewShip(@RequestBody Vaisseau vaisseau) {
    return vaisseauService.createShip(vaisseau);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteShip(@PathVariable("id") Integer id) {
    return this.vaisseauService.deleteShipById(id);
  }

  @PutMapping("{id}")
  public Vaisseau updateShip(@PathVariable("id") Integer id, @RequestBody Vaisseau vaisseau) {
    vaisseau.setId(id);
    return vaisseauService.updateShip(vaisseau);
  }
}
