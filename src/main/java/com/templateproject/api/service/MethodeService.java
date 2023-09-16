package com.templateproject.api.service;

import java.util.ArrayList;

import org.hibernate.mapping.Array;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import com.templateproject.api.entity.Planet;
import com.templateproject.api.entity.Ressource;
import com.templateproject.api.repository.PlanetRepository;
import com.templateproject.api.repository.PlayerRepository;
import com.templateproject.api.repository.RessourceRepository;

@Service
public class MethodeService {

    private final BuildingService buildingService;
    private final RessourceService ressourceService;
    private final PlayerRepository playerRepository;
    private final RessourceRepository ressourceRepository;
    private final PlanetRepository planetRepository;

    MethodeService(BuildingService buildingService, RessourceService ressourceService,
            PlayerRepository playerRepository, RessourceRepository ressourceRepository,
            PlanetRepository planetRepository) {
        this.buildingService = buildingService;
        this.ressourceService = ressourceService;
        this.playerRepository = playerRepository;
        this.ressourceRepository = ressourceRepository;
        this.planetRepository = planetRepository;
    }

    public void buildingLevelUp(Integer buildingId, Integer planetId) {
        // ressourceService.findAllByPlanet(planetId);

    }

    public void initializeRessourcesForNewPlayer(Integer playerId) {
        System.out.println("j essaie de init");
        var playerToUpdate = playerRepository.findByPlayerId(playerId);
        var ironPlayer = new Ressource("iron", 5000, playerToUpdate);
        var diamondPlayer = new Ressource("diamond", 5000, playerToUpdate);
        var energyPlayer = new Ressource("energy", 5000, playerToUpdate);
        var hydrogenePlayer = new Ressource("hydrogene", 5000, playerToUpdate);
        ressourceRepository.save(ironPlayer);
        ressourceRepository.save(diamondPlayer);
        ressourceRepository.save(energyPlayer);
        ressourceRepository.save(hydrogenePlayer);
        System.out.println("j ai fini d init");
    }

    public void definePlanetForPlayer(Integer idPlayer) {
        var planetList = planetRepository.findAll();
        var planetListEmpty = new ArrayList<>();
        try {
            for (Planet planet : planetList) {
                if (planet.getPlayer() == null) {
                    planetListEmpty.add(planet);
                }
                // To do random assignment
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
