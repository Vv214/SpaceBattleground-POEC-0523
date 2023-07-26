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

import com.templateproject.api.service.FleetService;
import com.templateproject.api.entity.Fleet;

@RestController
@RequestMapping("/Fleet")
public class FleetController {

    private final FleetService FleetService;

    public FleetController(FleetService FleetService) {
        this.FleetService = FleetService;
    };

    @GetMapping
    public List<Fleet> getAllFleet() {
        return FleetService.getFleet();
    }

    @GetMapping("{id}")
    public Optional<Fleet> getFleet(@PathVariable("id") int id) {
        return FleetService.getFleet(id);
    }

    @PostMapping
    public Fleet createFleet(@RequestBody Fleet Fleet) {
        return FleetService.createFleet(Fleet);
    }

    @PutMapping("{id}")
    public Fleet updateFleet(@PathVariable("id") int id, @RequestBody Fleet Fleet) {
        Fleet.setId(id);
        return FleetService.updateFleet(Fleet);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFleet(@PathVariable("id") Integer id) {
    return this.FleetService.deleteFleetById(id);
    }

}
