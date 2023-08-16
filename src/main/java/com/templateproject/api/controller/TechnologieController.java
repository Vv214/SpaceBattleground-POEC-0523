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

    // CREATE
    @PostMapping("/technologie")
    public ResponseEntity<TechnologiePayload> addTechnologie(@RequestBody Technologie technologie) {
        var payload = new TechnologiePayload();
        try {
            technologieService.add(
                    technologie.getName(),
                    technologie.getDescription(),

                    technologie.getIronPrice(),
                    technologie.getDiamondPrice(),
                    technologie.getHydrogenPrice(),
                    technologie.getEnergyPrice(),

                    technologie.getLevel(),
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

    // RESEARCH ALL
    @GetMapping("/technologie")
    public ResponseEntity<Payload> getAllTechnologie() {
        var payload = new Payload();
        try {
            payload.setData(technologieService.getAllTechnologies());
            payload.setMessage("Get all Technologies");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // RESEARCH ONE
    @GetMapping("/technologie/{name}")
    public ResponseEntity<Payload> getTechnologieByName(@PathVariable String name) {
        var payload = new Payload();
        try {
            var technologie = technologieService.getTechnologie(name);
            payload.setMessage("Get Technologie by Name '" + name + "'");
            payload.setData(technologie);
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // UPDATE ONE
    @PutMapping("/technologie/{name}")
    public ResponseEntity<TechnologiePayload> updateTechnologie(@PathVariable String name,
            @RequestBody Technologie technologie) {
        var payload = new TechnologiePayload();
        try {

            payload.setName(technologie.getName());
            payload.setIronPrice(technologie.getIronPrice());
            payload.setDiamondPrice(technologie.getDiamondPrice());
            payload.setHydrogenPrice(technologie.getHydrogenPrice());
            payload.setEnergyPrice(technologie.getEnergyPrice());
            payload.setDescription(technologie.getDescription());
            payload.setLevel(technologie.getLevel());
            payload.setCoef_modifier(technologie.getCoef_modifier());
            payload.setTimeSearch(technologie.getTimeSearch());
            payload.setDone(technologie.isDone());

            technologieService.updateTechnologie(name, payload);
            payload.setMessage("Technologie Update");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { // TODO NOT FOUND && verify all the method
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // DELETE ONE
    @DeleteMapping("/technologie/{name}")
    public ResponseEntity<Payload> deleteTechnologie(@PathVariable String name) {
        // TODO set message ?
        var payload = new Payload();
        try {
            technologieService.delete(name);
            // payload.setMessage("deleted");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { // TODO 4.x.x
            // payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
