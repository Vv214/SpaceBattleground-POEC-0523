package com.templateproject.api.service;

public class MethodeService {

    private final BuildingService buildingService;
    private final RessourceService ressourceService;

    MethodeService(BuildingService buildingService, RessourceService ressourceService) {
        this.buildingService = buildingService;
        this.ressourceService = ressourceService;
    }

    public void buildingLevelUp(Integer buildingId, Integer planetId) {
        ressourceService.findAllByPlanet(planetId);

    }

}
