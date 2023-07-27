package com.templateproject.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.controller.payload.BuildingPayload;
import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.entity.Building;
import com.templateproject.api.service.BuildingService;

@RestController
public class BuildingController {

    private BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    public BuildingController() {

    }

    // @GetMapping("{building}")
    // public Building getBuilding(@PathVariable("building") String name) {
    // return this.buildingService.getBuilding(name);
    // }

    /*
     * @PutMapping("{building}")
     * public BuildingPayload updateBuilding(@PathVariable("building") String name,
     * 
     * @RequestBody Building building) {
     * var buildingToUpdate = new BuildingPayload();
     * // todo change fonction declaration // change Object
     * buildingToUpdate = buildingService.updateBuilding(name, building);
     * return buildingToUpdate;
     * }
     */

    @PostMapping("/building")
    public ResponseEntity<Payload> createBuilding(@RequestBody BuildingPayload building) {
        var payload = new Payload();
        try {
            buildingService.add(building.getName(), building.getType(), building.getLevel(), building.getBuildingSize(),
                    building.getDescription(), building.getCoeff_prod(), building.getIronPrice(),
                    building.getDiamondPrice(), building.getHydrogenPrice(), building.getPriceEnergy(),
                    building.getTimeBuilding());
            payload.setMessage(building.getName() + "created");
            return new ResponseEntity<>(payload, HttpStatus.CREATED);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            return new ResponseEntity<Payload>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buildings")
    public ResponseEntity<Payload> getBuildingsList() {
        var payload = new Payload();
        try {
            payload.setMessage("Get All Buildings");
            payload.setData(buildingService.getBuildings());
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/buildings/{name}")
    public ResponseEntity<Payload> updateBuilding(@PathVariable String name, @RequestBody BuildingPayload building) {
        var payload = new Payload();
        try {
            buildingService.updateBuilding(name, building);
            payload.setMessage("Building updated successfully");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {

            // Finir ca
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
            // TODO: handle exception
        }
    }
}
