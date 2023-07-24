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
    
    public TechnologieController(TechnologieService technologieService){
        this.technologieService = technologieService;
    }
    
    @PostMapping("/technologie")
    public ResponseEntity<Payload> addTechnologie(@RequestBody Technologie technologie){
        var payload = new Payload();
        try {
            technologieService.add(
                 technologie.getName(),
                 technologie.getPriceRessource1(),
                 technologie.getPriceRessource2(),
                 technologie.getPriceRessource3(),
                 technologie.getPriceEnergy(),
                 technologie.getDescription(), // error type
                 technologie.getLvl(),
                 technologie.getCoef_modifier(),
                 technologie.getTimeSearch(),
                 technologie.isDone()
            );
        } catch (Exception e) {
                    payload.setMessgae(e.getMessage());
                    return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @GetMapping("/technologie")
    public ResponseEntity<Payload> getAllTechnoligie(){
        var payload = new Payload();
        try {
            payload.setData(technologieService.getAll());
            payload.setMessgae("Get all Technologies");
            return new ResponseEntity<>(payload, HttpStatus.OK);}
            
        catch (Exception e) {
                payload.setMessgae(e.getMessage());
                payload.setData(null);
                return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/technologie/{name}")
    public ResponseEntity<Payload> getTechnoligieByName(@PathVariable String name){
        var payload = new Payload();
        try {
            var technologie = technologieService.getTechnoligieByName();
            payload.setMessgae("Get Technologie by Name '"+ name +"'");
            payload.setData(technologie);
            return new ResponseEntity<>(payload, HttpStatus.OK);}
            
        catch (Exception e) {
                payload.setMessgae(e.getMessage());
                payload.setData(null);
                return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }    

    @PutMapping("/technologie/{name}")
    public ResponseEntity<Payload> updateTechnologie (@PathVariable String name, @RequestBody Technologie technologie){
        var payload = new Payload();
        try {
            technologieService.update(
                    name,
                    technologie.getName(),
                    technologie.getPriceRessource1(),
                    technologie.getPriceRessource2(),
                    technologie.getPriceRessource3(),
                    technologie.getPriceEnergy(),
                    technologie.getDescription(),
                    technologie.getLvl(),
                    technologie.getCoef_modifier(),
                    technologie.getTimeSearch(),
                    technologie.isDone()
            );
            payload.setMessgae("Technologie Update");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }   
        catch (Exception e) { //TODO NOT FOUND
                payload.setMessgae(e.getMessage());
                payload.setData(null);
                return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
                }
           
    }

    @DeleteMapping ("/technologie/{name}")
    public ResponseEntity<Payload> deleteTechnologie(@PathVariable String name){
        var payload = new Payload();
        try{
            technologieService.delete(name);
            payload.setMessgae("'" + login + "' deleted");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e){ //TODO 4.x.x
            payload.setMessgae(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
