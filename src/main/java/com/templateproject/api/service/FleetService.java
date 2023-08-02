package com.templateproject.api.service;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Fleet;
import com.templateproject.api.repository.FleetRepository;

@Service
public class FleetService {
  private final FleetRepository FleetRepository;

 
  public FleetService(FleetRepository FleetRepository) {
    this.FleetRepository = FleetRepository;
  }
  
  //CREATE  
  public Fleet createFleet(Fleet Fleet) {
      return FleetRepository.save(Fleet);
  }

  //RESEARCH ALL
  public List<Fleet> getFleet() {
      return FleetRepository.findAll();
    }
  //RESEARCH ONE
  public Optional<Fleet> getFleet(int id) {
      return FleetRepository.findById(id);
  }
  //UPDATE ONE
  public Fleet updateFleet(Fleet Fleet) {
    Fleet currentFleet = FleetRepository.findById(Fleet.getId()).get();
    
      currentFleet.setName(Fleet.getName());
      currentFleet.setMaxNumberShip(Fleet.getMaxNumberShip());
      currentFleet.setPositionX(Fleet.getPositionX());
      currentFleet.setPositionY(Fleet.getPositionY());
      currentFleet.setPower(Fleet.getPower());
      currentFleet.setTotalCapacity(Fleet.getTotalCapacity());
      currentFleet.setTotalPv(Fleet.getTotalPv());
      currentFleet.setSpeed(Fleet.getSpeed());
      
      Fleet updateFleet = FleetRepository.save(currentFleet);
        return updateFleet;
  }
  
  //DELETE ONE 
  public ResponseEntity<String> deleteFleetById(Integer id) {
      FleetRepository.deleteById(id);
      return new ResponseEntity<>("Fleet successfully deleted!", HttpStatus.OK);
  }
}
