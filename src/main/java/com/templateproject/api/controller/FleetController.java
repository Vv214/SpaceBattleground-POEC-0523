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

import com.templateproject.api.service.FleetService;
import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.entity.Fleet;

@RestController
@RequestMapping("/Fleet")
public class FleetController {

    private final FleetService fleetService;

    public FleetController(FleetService fleetService) {
        this.fleetService = fleetService;
    };
//CREATE ONE
    @PostMapping 
    public ResponseEntity<Payload> createFleet(@RequestBody Fleet fleet) {
        var payload = new Payload();
        try {
            fleetService.createFleet(
                fleet.getName(),
                fleet.getMaxNumberShip(),
                fleet.getPositionX(),
                fleet.getPositionY(),
                fleet.getPower(),
                fleet.getTotalPv(),
                fleet.getTotalCapacity(),
                fleet.getSpeed()
            );
            payload.setMessage("The Fleet " + fleet.getName()+ " created.");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
            // TODO: handle exception
        }
    }    

//RESARCH ALL
    @GetMapping ("/fleets")
    public ResponseEntity<Payload> getAllFleet() {
        var payload = new Payload(); 
        try {
            payload.setData(fleetService.getAllFleets());  
            payload.setMessage("Get all Fleet : ");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage("Get all Fleet : ");
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
            // TODO: handle exception
        }
    }

//RESEARCH ONE
    @GetMapping("{name}")
    public ResponseEntity<Payload> getFleet(@PathVariable String name) {
        var payload = new Payload(); 
        try {
            var fleet = fleetService.getFleet(name);
            payload.setMessage("Get Fleet By Name : " + name +"'");
            payload.setData(fleet); 
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null); 
            return new ResponseEntity<>(payload, HttpStatus.OK);
            // TODO: handle exception
        }
    }

//UPDATE ONE 
    @PutMapping("/user/{name}")
    public ResponseEntity<Payload> updateFleet(@PathVariable String name, @RequestBody Fleet fleet) {
        var payload = new Payload(); 
        try {
            fleetService.updateFleet(
                name, 
                fleet.getName(),
                fleet.getMaxNumberShip(),
                fleet.getPositionX(),
                fleet.getPositionY(),
                fleet.getPower(),
                fleet.getTotalPv(),
                fleet.getTotalCapacity(),
                fleet.getSpeed()
            );
            payload.setMessage("Fleet Updated");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.OK);
            // TODO: handle exception
        }
    }
//DELETE ONE
    @DeleteMapping("{name}")
    public ResponseEntity<Payload> deleteFleet(@PathVariable String name) {
      var payload = new Payload();
        try {
            fleetService.deleteFleetByName(name);
            payload.setMessage("'" + name + "' deleted");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { //TODO 4.x.x
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}