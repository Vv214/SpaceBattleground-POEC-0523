package com.templateproject.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.templateproject.api.controller.payload.BuildingPayload;
import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.entity.Building;
import com.templateproject.api.service.BuildingService;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BuildingController  {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    // CREATE
    @PostMapping("/building")
    public ResponseEntity<BuildingPayload> createBuilding(@RequestBody Building building) {
        var payload = new BuildingPayload();
        try {
            buildingService.add(
                    building.getName(),
                    building.getType(),
                    building.getLevel(),
                    building.getDescription(),
                    building.getCoeff_prod(),
                    building.getIronPrice(),
                    building.getDiamondPrice(),
                    building.getHydrogenPrice(),
                    building.getEnergyPrice(),
                    building.getTimeBuilding(),
                    building.getTimeToStart());
            payload.setMessage(building.getName() + "created");
            return new ResponseEntity<>(payload, HttpStatus.CREATED);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // RESEARCH ALL
    @GetMapping("/building")
    public ResponseEntity<Payload> getBuildingsList() {
        var payload = new Payload();
        System.out.println("dans le building back");
        try {
            System.out.println("je suis avangt de charger le building ");
            payload.setMessage("Get All Buildings");
            System.out.println(this.buildingService);
            // Object listBuilding = ;
            payload.setData(buildingService.getAll());
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage() + " ici ");
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // RESEARCH ONE

    @GetMapping("/building/{name}")
    public ResponseEntity<Payload> getBuilding(@PathVariable String name) {
        var payload = new Payload();

        try {

            var building = buildingService.getBuilding(name);
            payload.setMessage("Get Building " + name + "'");
            payload.setData(building);
            return new ResponseEntity<>(payload, HttpStatus.OK);

        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
            // TODO: handle exception
        }
    }

    // UPDATE ONE
    @PutMapping("/building/{name}")
    public ResponseEntity<BuildingPayload> updateBuilding(@PathVariable String name, @RequestBody Building building) {
        var payload = new BuildingPayload();
        try {
            payload.setName(building.getName());
            payload.setType(building.getType());
            payload.setLevel(building.getLevel());
            payload.setDescription(building.getDescription());
            payload.setCoeff_prod(building.getCoeff_prod());
            payload.setIronPrice(building.getIronPrice());
            payload.setDiamondPrice(building.getDiamondPrice());
            payload.setHydrogenPrice(building.getHydrogenPrice());
            payload.setEnergyPrice(building.getEnergyPrice());
            payload.setTimeBuilding(building.getTimeBuilding());
            payload.setTimeToStart(building.getTimeToStart());

            buildingService.updateBuilding(name, payload);
            payload.setMessage("Building updated successfully");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {

            // Finir ca
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
            // TODO: handle exception
        }
    }

    // DELETE ONE
    @DeleteMapping("/building/{name}")
    public ResponseEntity<Payload> deleteBuilding(@PathVariable String name) {
        // TODO set Confirm Message
        var payload = new Payload();
        try {
            buildingService.deleteBuilding(name);
            // payload.setMessage("deleted");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { // TODO 4.x.x
            // payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}