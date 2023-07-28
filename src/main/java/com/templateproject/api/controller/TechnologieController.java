package com.templateproject.api.controller;

import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.controller.payload.TechnologiePayload;
import com.templateproject.api.entity.Technologie;
import com.templateproject.api.service.TechnologieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class TechnologieController {

    private final TechnologieService technologieService;

    public TechnologieController(TechnologieService technologieService) {
        this.technologieService = technologieService;
    }

    @PostMapping("/technologie")
    public ResponseEntity<TechnologiePayload> addTechnologie(@RequestBody Technologie technologie) {
        var payload = new TechnologiePayload();
        try {
            technologieService.add(
                    technologie.getName(),
                    technologie.getIronPrice(),
                    technologie.getDiamondPrice(),
                    technologie.getHydrogenPrice(),
                    technologie.getEnergyPrice(),
                    technologie.getDescription(),
                    technologie.getLvl(),
                    technologie.getCoef_modifier(),
                    technologie.getTimeSearch(),
                    technologie.isDone());
            payload.setMessage(technologie.getName() + "created");
            return new ResponseEntity<>(payload, HttpStatus.CREATED);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/technologie")
    public ResponseEntity<Payload> getAllTechnoligie() {
        var payload = new Payload();
        try {
            payload.setData(technologieService.getTechnologies());
            payload.setMessage("Get all Technologies");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }

        catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/technologie/{name}")
    public ResponseEntity<Payload> getTechnoligieByName(@PathVariable String name) {
        var payload = new Payload();
        try {
            var technologie = technologieService.getTechnologies();
            payload.setMessage("Get Technologie by Name '" + name + "'");
            payload.setData(technologie);
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/technologie/{name}")
    public void updateTechnologie(@PathVariable String name, @RequestBody Technologie technologie) {
        var payload = new TechnologiePayload();
        try {
            technologieService.updateTechnologie(name, payload);
            // technologie.getName(),
            // technologie.getIronPrice(),
            // technologie.getDiamondPrice(),
            // technologie.getHydrogenPrice(),
            // technologie.getEnergyPrice(),
            // technologie.getDescription(),
            // technologie.getLvl(),
            // technologie.getCoef_modifier(),
            // technologie.getTimeSearch(),
            // technologie.isDone());
            // payload.setMessage("Technologie Update");
            // return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { // TODO NOT FOUND && verify all the method
            payload.setMessage(e.getMessage());
            // payload.setData(null);
            // return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/technologie/{name}")
    public ResponseEntity<Payload> deleteTechnologie(@PathVariable String name) {
        // TODO set message ?
        var payload = new Payload();
        try {
            technologieService.delete(name);
            // payload.setMessae("deleted");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { // TODO 4.x.x
            // payload.setMessae(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
