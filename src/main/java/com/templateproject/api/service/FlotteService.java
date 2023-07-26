package com.templateproject.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Flotte;
import com.templateproject.api.entity.Player;
import com.templateproject.api.repository.FlotteRepository;

@Service
public class FlotteService {
  private final FlotteRepository flotteRepository;

  @Autowired
  public FlotteService(FlotteRepository flotteRepository) {
    this.flotteRepository = flotteRepository;
  }

public List<Flotte> getFlotte() {
    return flotteRepository.findAll();
}

public Flotte createFlotte(Flotte flotte) {
    return flotteRepository.save(flotte);
}

public Flotte updateFlotte(Flotte flotte) {
  Flotte currentFlotte = flotteRepository.findById(flotte.getId()).get();
    currentFlotte.setName(flotte.getName());
    currentFlotte.setMaxNumberShip(flotte.getMaxNumberShip());
    currentFlotte.setPositionX(flotte.getPositionX());
    currentFlotte.setPositionY(flotte.getPositionY());
    currentFlotte.setTotalPower(flotte.getTotalPower());
    currentFlotte.setTotalCapacity(flotte.getTotalCapacity());
    currentFlotte.setTotalPv(flotte.getTotalPv());
    currentFlotte.setVitesse(flotte.getVitesse());
    currentFlotte.setCarburant(flotte.getCarburant());
    Flotte updateFlotte = flotteRepository.save(currentFlotte);
      return updateFlotte;
}

public Optional<Flotte> getFlotte(int id) {
    return flotteRepository.findById(id);
}

public ResponseEntity<String> deleteFlotteById(Integer id) {
    flotteRepository.deleteById(id);
    return new ResponseEntity<>("Flotte successfully deleted!", HttpStatus.OK);
}
}
