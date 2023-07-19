package com.templateproject.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.templateproject.api.entity.Building;
import com.templateproject.api.service.BuildingService;

@RestController
public class BuildingController {

    private BuildingService buildingService;

    BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("/build")
    public Building createBuilding(@ResquestBody BuildingPayload bulding){
        //String name = bulding.get("name");
        buildingService.create(bulding);
       
    }

    @GetMapping("/buildings")
    private List<Building> getBuildingsList()
}
