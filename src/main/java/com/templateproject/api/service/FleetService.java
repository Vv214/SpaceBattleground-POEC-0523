package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Fleet;
import com.templateproject.api.repository.FleetRepository;

@Service
public class FleetService {
  private final FleetRepository fleetRepository;


  public FleetService(FleetRepository fleetRepository) {
    this.fleetRepository = fleetRepository;
  }

  // CREATE
  public void createFleet(
      String name,
      Integer maxNumberShip,
      Integer positionX,
      Integer positionY,
      Integer power,
      Integer totalPv,
      Integer totalCapacity,
      Integer speed 
      ) {
    var fleet = new Fleet(name, maxNumberShip, positionX, positionY, power, totalPv, totalCapacity, speed);
    fleetRepository.save(fleet);  
        
  }

  // RESEARCH ALL
  public List<HashMap<String, Object>> getAllFleets() {
    var payload = new ArrayList<HashMap<String,Object>>();

    List <Fleet> fleetList = fleetRepository.findAll(); 
    for (var fleet : fleetList){
      var newFleet = new HashMap<String,Object>();
      newFleet.put("Fleet's Name : ", fleet.getName()); 
      newFleet.put("Max Fleet's Size : ", fleet.getMaxNumberShip()); 
      newFleet.put("Fleet's Position X :", fleet.getPositionX()); 
      newFleet.put("Fleet's Position Y: ", fleet.getPositionY()); 
      newFleet.put("Fleet's Fire Power : ", fleet.getPower()); 
      newFleet.put("Fleet's PV : ", fleet.getTotalPv()); 
      newFleet.put("Fleet's Capcity : ", fleet.getTotalCapacity()); 
      newFleet.put("Fleet's Speed : ", fleet.getSpeed());  
      payload.add(newFleet);
    }
    return payload; 
  }

  // RESEARCH ONE
  public HashMap<String, Object> getFleet(String name) {
    //TO DO CHECK PARAM 
    var fleet = new HashMap<String,Object>();

    var fleetEntity = fleetRepository.findByName(name);
      fleet.put("",fleetEntity.getName()); 
      fleet.put("",fleetEntity.getMaxNumberShip()); 
      fleet.put("",fleetEntity.getPositionX()); 
      fleet.put("",fleetEntity.getPositionY()); 
      fleet.put("",fleetEntity.getPower()); 
      fleet.put("",fleetEntity.getTotalPv()); 
      fleet.put("",fleetEntity.getTotalCapacity()); 
      fleet.put("",fleetEntity.getSpeed());  

    return fleet; 
  }

  // UPDATE ONE
  public void updateFleet(
    String nameFleetTarget, 
      String name,
      Integer maxNumberShip,
      Integer positionX,
      Integer positionY,
      Integer power,
      Integer totalPv,
      Integer totalCapacity,
      Integer speed 
    
    ) throws Exception {

    var fleet = fleetRepository.findByName(name); 
    if (fleet == null){
      throw new Exception (nameFleetTarget + "doesn't exist.");
      // TODO make our Exception (404 - Not found)
    }
    if(name != null){
      fleet.setName(name);
    }
    if(maxNumberShip != 0){
      fleet.setMaxNumberShip(maxNumberShip);
    }
    if(positionX !=0){
      fleet.setPositionX(positionX);
    }
    if(positionY !=0){
      fleet.setPositionY(positionY);
    }
    if(power !=0){
      fleet.setPower(power);
    }
    if(totalPv !=0){
      fleet.setTotalPv(totalPv);
    }
    if(totalCapacity !=0){
      fleet.setTotalCapacity(totalCapacity);
    }
    if (speed !=0){
      fleet.setSpeed(speed);
    } 
    
    fleetRepository.save(fleet);
    }    
  

  // DELETE ONE
  public ResponseEntity<String> deleteFleetByName(String name) {
    fleetRepository.deleteByName(name);
    return new ResponseEntity<String>("Fleet successfully deleted!", HttpStatus.OK);
  }
}
