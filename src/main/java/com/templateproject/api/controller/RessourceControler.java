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

import com.templateproject.api.controller.payload.Payload;
import com.templateproject.api.entity.Ressource;
import com.templateproject.api.service.RessourceService;

@RestController

public class RessourceControler {

   private final RessourceService ressourceService;

   RessourceControler(RessourceService ressourceService) {
        this.ressourceService = ressourceService;
    }

    @PostMapping("/ressource")
    public ResponseEntity<Payload> addRessource(@RequestBody Ressource ressource) {
        var payload = new Payload();
        try {
            ressourceService.add(ressource);
            payload.setData(ressource);
            payload.setMessage(ressource.getName() + " added");
            return new ResponseEntity<>(payload ,HttpStatus.CREATED);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
                return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ressource")
    public ResponseEntity<Payload> getAllRessource() {
        var payload = new Payload();
        try {
            payload.setData(ressourceService.getAll());
            payload.setMessage("Get all ressource");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ressource/{name}")
    public ResponseEntity<Payload> getRessourceByTag(@PathVariable("name") String name) {
        var payload = new Payload();
        try {
            // var ressource = ressourceService.getByName(name);
            payload.setMessage("Get ressource by name '" + name +"'");
            payload.setData(ressourceService.getByName(name));
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ressource/{name}")
    public ResponseEntity<Payload> updateRessource(@PathVariable("name") String name, @RequestBody Ressource ressource) {
        var payload = new Payload();
        try {
            Ressource updatedRessource = ressourceService.update(name, ressource);
            payload.setData(updatedRessource);
            payload.setMessage("Ressource updated");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { 
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ressource/{name}")
    public ResponseEntity<Payload> deleteRessource(@PathVariable("name") String name) {
        var payload = new Payload();
        try {
            ressourceService.delete(name);
            payload.setMessage("'" + name+ "' deleted");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { 
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

