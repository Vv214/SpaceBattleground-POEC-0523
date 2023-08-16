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

import jakarta.servlet.http.HttpServletRequest;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BuildingController {

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
                    building.getIsBuild(),
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
            System.out.println("je suis avant de charger le building ");
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
            if (building.getName() != null) {
                payload.setName(building.getName());
            }
            if (building.getLevel() != null) {
                payload.setLevel(building.getLevel());
            }
            if (building.getLevel() != null) {
                payload.setType(building.getType());
            }
            if (building.getDescription() != null) {
                payload.setDescription(building.getDescription());
            }
            if (building.getCoeff_prod() != null) {
                payload.setCoeff_prod(building.getCoeff_prod());
            }
            if (building.getIronPrice() != null) {
                payload.setIronPrice(building.getIronPrice());
            }
            if (building.getDiamondPrice() != null) {
                payload.setDiamondPrice(building.getDiamondPrice());
            }
            if (building.getHydrogenPrice() != null) {
                payload.setHydrogenPrice(building.getHydrogenPrice());
            }
            if (building.getEnergyPrice() != null) {
                payload.setEnergyPrice(building.getEnergyPrice());
            }
            // if(building.getIsBuild() != null) {
            payload.setIsBuild(building.getIsBuild());
            // }
            if (building.getTimeBuilding() != null) {
                payload.setTimeBuilding(building.getTimeBuilding());
            }
            if (building.getTimeToStart() != null) {
                payload.setTimeToStart(building.getTimeToStart());
            }
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

    @GetMapping("/building/{id}/levelup")
    public ResponseEntity<Payload> levelUp(@PathVariable Integer id, HttpServletRequest request) {
        var payload = new Payload();
        try {
            // var playerID = (Integer) request.getAttribute("playerID");
            // to do verif building appratien au player id
            // to do verif ressource methode service
            buildingService.levelUp(id);

        } catch (Exception e) {

            // TODO: handle exception
        }
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }
}