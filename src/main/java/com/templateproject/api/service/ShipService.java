package com.templateproject.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.entity.Ship;
import com.templateproject.api.repository.ShipRepository;

@Service
public class ShipService {
  private final ShipRepository shipRepository;

  public ShipService(ShipRepository shipRepository) {
    this.shipRepository = shipRepository;
  }

  
  //CREATE ONE
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
    Integer size,
    Integer quantity)
{
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
          size,
          quantity
    );
    shipRepository.save(ship);
  }

  //RESEARCH ALL
  public List<HashMap<String, Object>> getAllShips() {
    var payload = new ArrayList<HashMap<String,Object>>();

    List <Ship> shipList = shipRepository.findAll();
    for (var ship : shipList) {
      var newShip= new HashMap<String, Object>();
              newShip.put("Name : ", ship.getName());
              newShip.put("Type : ", ship.getType());
              newShip.put("Iron Price : ", ship.getIronPrice());
              newShip.put("Diamond Price : ", ship.getDiamondPrice());
              newShip.put("Hydrogen Price : ", ship.getHydrogenPrice());
              newShip.put("Energu Price : ", ship.getEnergyPrice());
              newShip.put("PV : ", ship.getPv());
              newShip.put("Damage : ", ship.getDamage());
              newShip.put("Fuel Capacity : ", ship.getFuel());
              newShip.put("Speed : ", ship.getSpeed());
              newShip.put("Capacity : ", ship.getCapacity());
              newShip.put("null", ship.getSize());
              newShip.put("null", ship.getQuantity());
              payload.add(newShip);     
    }
    return payload;
  }

  //RESEARCH ONE
  public HashMap<String, Object> getShipByName(String name) {
    var ship = new HashMap<String,Object>();
    
    var shipEntity = shipRepository.findByName(name);
              ship.put("Name : ", shipEntity.getName());
              ship.put("Type : ", shipEntity.getType());
              ship.put("Iron Price : ", shipEntity.getIronPrice());
              ship.put("Diamond Price : ", shipEntity.getDiamondPrice());
              ship.put("Hydrogen Price : ", shipEntity.getHydrogenPrice());
              ship.put("Energu Price : ", shipEntity.getEnergyPrice());
              ship.put("PV : ", shipEntity.getPv());
              ship.put("Damage : ", shipEntity.getDamage());
              ship.put("Fuel Capacity : ", shipEntity.getFuel());
              ship.put("Speed : ", shipEntity.getSpeed());
              ship.put("Capacity : ", shipEntity.getCapacity());
              ship.put("null", shipEntity.getSize());
              ship.put("null", shipEntity.getQuantity());

    return ship;
  }
  //UPDATE ONE
  public void updateShip (
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
    Integer size,
    Integer quantity
    ) 
    throws Exception
    {
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
        if (diamondPrice != 0){
          shipUpdate.setDiamondPrice(diamondPrice);
        }
        if(hydrogenPrice != 0){
          shipUpdate.setHydrogenPrice(hydrogenPrice);
        }
        if(energyPrice != 0){
          shipUpdate.setenergyPrice(energyPrice);
        }


        shipRepository.save(shipUpdate);

  }

  //DELETE ONE
  public ResponseEntity<String> deleteShipById(Integer id) {
    shipRepository.deleteById(id);
    return new ResponseEntity<>("Ship successfully deleted!", HttpStatus.OK);
  }


}
