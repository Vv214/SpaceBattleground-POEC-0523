package com.templateproject.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Ship;
import com.templateproject.api.repository.ShipRepository;

@Service
public class ShipService {
  private final ShipRepository ShipRepository;

  public ShipService(ShipRepository ShipRepository) {
    this.ShipRepository = ShipRepository;
  }

  public List<Ship> getAllShips() {
    return ShipRepository.findAll();
  }

  public Ship getShip(Integer id) {
    Optional<Ship> optionalShip = ShipRepository.findById(id);
    return optionalShip.get();
  }

  public Ship createShip(Ship Ship) {
    return ShipRepository.save(Ship);
  }

  public ResponseEntity<String> deleteShipById(Integer id) {
    ShipRepository.deleteById(id);
    return new ResponseEntity<>("Ship successfully deleted!", HttpStatus.OK);
  }

  public Ship updateShip(Ship Ship) {
    Ship currentShip = ShipRepository.findById(Ship.getId()).get();
    currentShip.setName(Ship.getName());
    currentShip.setType(Ship.getType());
    currentShip.setIronPrice(Ship.getIronPrice());
    currentShip.setDiamondPrice(Ship.getDiamondPrice()); 
    currentShip.setHydrogenPrice(Ship.getHydrogenPrice());
    currentShip.setPriceEnergy(Ship.getPriceEnergy());
    currentShip.setDamage(Ship.getDamage());
    currentShip.setPV(Ship.getPv());
    currentShip.setFuel(Ship.getFuel());
    currentShip.setSpeed(Ship.getSpeed());
    currentShip.setCapacity(Ship.getCapacity());
    Ship updateShip = ShipRepository.save(currentShip);
    return updateShip;
  }

}
