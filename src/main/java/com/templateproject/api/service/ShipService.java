package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.controller.payload.ShipPayload;
import com.templateproject.api.entity.Ship;
import com.templateproject.api.repository.ShipRepository;

@Service
public class ShipService {
  private final ShipRepository shipRepository;

  public ShipService(ShipRepository shipRepository) {
    this.shipRepository = shipRepository;
  }

  public Object getAllShips() {
    var lightShip = getShipByName("Chasseur léger");
    var mediumShip = getShipByName("Chasseur lourd");
    var heavyShip = getShipByName("Destroyer");
    var scoutShip = getShipByName("Eclaireur");
    var cargoShip = getShipByName("Transporteur léger");
    var heavyCargoShip = getShipByName("Transporteur lourd");
    var recyclerShip = getShipByName("Récolteur");
    var colonisateur = getShipByName("Colonisateur");

    var ships = new HashMap<String, Object>();
    ships.put("lightShip", lightShip);
    ships.put("mediumShip", mediumShip);
    ships.put("heavyShip", heavyShip);
    ships.put("scoutShip", scoutShip);
    ships.put("cargoShip", cargoShip);
    ships.put("heavyCargoShip", heavyCargoShip);
    ships.put("recyclerShip", recyclerShip);
    ships.put("colonisateur", colonisateur);
    System.out.println(ships + " ship back");
    return ships;
  }

  // CREATE ONE
  public void createShip(
      String name,
      String type,
      Integer ironPrice,
      Integer diamondPrice,
      Integer hydrogenPrice,
      Integer energyPrice,
      Integer pv,
      Integer damage,
      Integer fuel,
      Integer speed,
      Integer capacity,
      Integer quantity) {
    var ship = new Ship(
        name,
        type,
        ironPrice,
        diamondPrice,
        hydrogenPrice,
        energyPrice,
        pv,
        damage,
        fuel,
        speed,
        capacity,
        quantity);
    shipRepository.save(ship);
  }

  // //RESEARCH ALL
  // public List<HashMap<String, Object>> getAllShips() {
  // var payload = new ArrayList<HashMap<String,Object>>();

  // List <Ship> shipList = shipRepository.findAll();
  // for (var ship : shipList) {
  // var newShip= new HashMap<String, Object>();
  // newShip.put("name", ship.getName());
  // newShip.put("type", ship.getType());
  // newShip.put("ironPrice", ship.getIronPrice());
  // newShip.put("diamondPrice", ship.getDiamondPrice());
  // newShip.put("hydrogenPrice", ship.getHydrogenPrice());
  // newShip.put("energyPrice", ship.getEnergyPrice());
  // newShip.put("pv", ship.getPv());
  // newShip.put("damage", ship.getDamage());
  // newShip.put("fuel", ship.getFuel());
  // newShip.put("speed", ship.getSpeed());
  // newShip.put("capacity", ship.getCapacity());
  // newShip.put("quantity", ship.getQuantity());
  // payload.add(newShip);
  // }
  // return payload;
  // }

  // RESEARCH ALL
  public List<ShipPayload> getShips() {
    var shipPayload = new ArrayList<ShipPayload>();
    List<Ship> shipList = shipRepository.findAll();
    for (var ship : shipList) {

      var newShip = new ShipPayload();

      newShip.setName(ship.getName());
      newShip.setType(ship.getType());

      newShip.setIronPrice(ship.getIronPrice());
      newShip.setDiamondPrice(ship.getDiamondPrice());
      newShip.setHydrogenPrice(ship.getHydrogenPrice());
      newShip.setEnergyPrice(ship.getEnergyPrice());

      newShip.setPv(ship.getPv());
      newShip.setDamage(ship.getDamage());
      newShip.setFuel(ship.getFuel());
      newShip.setSpeed(ship.getSpeed());
      newShip.setCapacity(ship.getCapacity());
      newShip.setQuantity(ship.getQuantity());

      shipPayload.add(newShip);
    }
    return shipPayload;
  }

  // RESEARCH ONE
  public HashMap<String, Object> getShipByName(String name) {
    var ship = new HashMap<String, Object>();

    var shipEntity = shipRepository.findByName(name);
    ship.put("name", shipEntity.getName());
    ship.put("type", shipEntity.getType());
    ship.put("ironPrice", shipEntity.getIronPrice());
    ship.put("diamondPrice", shipEntity.getDiamondPrice());
    ship.put("hydrogenPrice", shipEntity.getHydrogenPrice());
    ship.put("energyPrice", shipEntity.getEnergyPrice());
    ship.put("pv", shipEntity.getPv());
    ship.put("damage", shipEntity.getDamage());
    ship.put("fuel", shipEntity.getFuel());
    ship.put("speed", shipEntity.getSpeed());
    ship.put("capacity", shipEntity.getCapacity());
    ship.put("quantity", shipEntity.getQuantity());

    return ship;
  }

  // UPDATE ONE
  public void updateShip(
      String shipTarget,
      String name,
      String type,
      Integer ironPrice,
      Integer diamondPrice,
      Integer hydrogenPrice,
      Integer energyPrice,
      Integer pv,
      Integer damage,
      Integer fuel,
      Integer speed,
      Integer capacity,
      Integer quantity

  ) throws Exception {

    var shipUpdate = shipRepository.findByName(shipTarget);

    if (shipUpdate == null) {
      throw new Exception(shipTarget + "doesn't exist"); // TODO make our Exception (404 - Not found)
    }
    if (name != null) {
      shipUpdate.setName(name);
    }
    if (type != null) {
      shipUpdate.setType(type);
    }
    if (ironPrice != 0) {
      shipUpdate.setIronPrice(ironPrice);
    }
    if (diamondPrice != 0) {
      shipUpdate.setDiamondPrice(diamondPrice);
    }
    if (hydrogenPrice != 0) {
      shipUpdate.setHydrogenPrice(hydrogenPrice);
    }
    if (energyPrice != 0) {
      shipUpdate.setenergyPrice(energyPrice);
    }
    if (pv != 0) {
      shipUpdate.setPV(pv);
    }
    if (damage != 0) {
      shipUpdate.setDamage(damage);
    }
    if (fuel != 0) {
      shipUpdate.setFuel(fuel);
    }
    if (speed != 0) {
      shipUpdate.setSpeed(speed);
    }
    if (capacity != 0) {
      shipUpdate.setCapacity(capacity);
    }
    if (quantity != 0) {
      shipUpdate.setQuantity(quantity);
    }
    shipRepository.save(shipUpdate);

  }

  // DELETE ONE
  public ResponseEntity<String> deleteShipByName(String name) {
    shipRepository.deleteByName(name);
    return new ResponseEntity<>("Ship successfully deleted!", HttpStatus.OK);
  }

  public Integer modifyQuantity(String name, Integer number) {
    var shipUpdate = shipRepository.findByName(name);
    number = 1; // To do : enlever le 1 si on veut ajouter plusieurs quaantité à la fois.
    shipUpdate.setQuantity(shipUpdate.getQuantity() + number);
    shipRepository.save(shipUpdate);
    return shipUpdate.getQuantity();
  }

}
