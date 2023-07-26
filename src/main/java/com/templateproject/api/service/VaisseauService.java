package com.templateproject.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Vaisseau;
import com.templateproject.api.repository.VaisseauRepository;

@Service
public class VaisseauService {
  private final VaisseauRepository vaisseauRepository;

  public VaisseauService(VaisseauRepository vaisseauRepository) {
    this.vaisseauRepository = vaisseauRepository;
  }

  public List<Vaisseau> getAllShips() {
    return vaisseauRepository.findAll();
  }

  public Vaisseau getShip(Integer id) {
    Optional<Vaisseau> optionalShip = vaisseauRepository.findById(id);
    return optionalShip.get();
  }

  public Vaisseau createShip(Vaisseau vaisseau) {
    return vaisseauRepository.save(vaisseau);
  }

  public ResponseEntity<String> deleteShipById(Integer id) {
    vaisseauRepository.deleteById(id);
    return new ResponseEntity<>("Ship successfully deleted!", HttpStatus.OK);
  }

  public Vaisseau updateShip(Vaisseau vaisseau) {
    Vaisseau currentShip = vaisseauRepository.findById(vaisseau.getId()).get();
    currentShip.setName(vaisseau.getName());
    currentShip.setType(vaisseau.getType());
    currentShip.setDamage(vaisseau.getDamage());
    currentShip.setPV(vaisseau.getPV());
    currentShip.setFuel(vaisseau.getFuel());
    currentShip.setSpeed(vaisseau.getSpeed());
    currentShip.setCapacity(vaisseau.getCapacity());
    Vaisseau updateShip = vaisseauRepository.save(currentShip);
    return updateShip;
  }

}
