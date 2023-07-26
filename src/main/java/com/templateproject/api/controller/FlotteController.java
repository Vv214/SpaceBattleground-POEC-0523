package com.templateproject.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.service.FlotteService;
import com.templateproject.api.entity.Flotte;

@RestController
@RequestMapping("/flotte")
public class FlotteController {

    private final FlotteService flotteService;

    public FlotteController(FlotteService flotteService) {
        this.flotteService = flotteService;
    };

    @GetMapping
    public List<Flotte> getAllFlotte() {
        return flotteService.getFlotte();
    }

    @GetMapping("{id}")
    public Optional<Flotte> getFlotte(@PathVariable("id") int id) {
        return flotteService.getFlotte(id);
    }

    @PostMapping
    public Flotte createFlotte(@RequestBody Flotte flotte) {
        return flotteService.createFlotte(flotte);
    }

    @PutMapping("{id}")
    public Flotte updateFlotte(@PathVariable("id") int id, @RequestBody Flotte flotte) {
        flotte.setId(id);
        return flotteService.updateFlotte(flotte);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFlotte(@PathVariable("id") Integer id) {
    return this.flotteService.deleteFlotteById(id);
    }

}
