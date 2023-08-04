package com.templateproject.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.entity.Clan;
import com.templateproject.api.service.ClanService;

import com.templateproject.api.controller.payload.Payload; 

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
//@RequestMapping("/clans")

public class ClanController {

   private final ClanService clanService;

   ClanController(ClanService clanService) {
        this.clanService = clanService;
    }
//CREATE
    @PostMapping("/clan")
    public ResponseEntity<Payload> addClan(@RequestBody Clan clan) {
        var payload = new Payload();
        try {
            clanService.add(clan);
            payload.setData(clan);
            payload.setMessage(clan.getClanName() + " added");
            return new ResponseEntity<>(payload ,HttpStatus.CREATED);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
                return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//RESEARCH ALL 
    @GetMapping("/clan")
    public ResponseEntity<Payload> getAllClan() {
        var payload = new Payload();
        try {
            payload.setData(clanService.getAll());
            payload.setMessage("Get all clan");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//RESEARCH ONE 
    @GetMapping("/clan/{name}")
    public ResponseEntity<Payload> getClanByTag(@PathVariable("name") String name) {
        var payload = new Payload();
        try {
            var clan = clanService.getByName(name);
            payload.setMessage("Get clan by name '" + name +"'");
            payload.setData(clan);
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) {
            payload.setMessage(e.getMessage());
            payload.setData(null);
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//UPDATE ONE
    @PutMapping("/clan/{name}")
    public ResponseEntity<Payload> updateClan(@PathVariable("name") String name, @RequestBody Clan clan) {
        var payload = new Payload();
        try {
            clanService.update(clan);
            payload.setData(clan);
            payload.setMessage("Clan updated");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { 
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//DELETE ONE 
    @DeleteMapping("/clan/{name}")
    public ResponseEntity<Payload> deleteClan(@PathVariable("name") String name) {
        var payload = new Payload();
        try {
            clanService.delete(name);
            payload.setMessage("'" + name+ "' deleted");
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } catch (Exception e) { 
            payload.setMessage(e.getMessage());
            return new ResponseEntity<>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
