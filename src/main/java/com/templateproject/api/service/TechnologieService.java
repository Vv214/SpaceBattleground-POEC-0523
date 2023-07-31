package com.templateproject.api.service;

import com.templateproject.api.controller.payload.TechnologiePayload;
import com.templateproject.api.entity.Technologie;
import com.templateproject.api.repository.TechnologieRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TechnologieService {

    private final TechnologieRepository technologieRepository;

    public TechnologieService(TechnologieRepository technologieRepository) {
        this.technologieRepository = technologieRepository;
    }

    public void add(
            
        String name,
        String description, 
        Integer ironPrice,
        Integer diamondPrice,
        Integer hydrogenPrice,
        Integer energyPrice,
        Integer level, 
        float coef_modifier,
        Date timeSearch,
        Date timeToStart,
        boolean isDone){

        var technologie = new Technologie(
                name,
                description, 
                ironPrice,
                diamondPrice,
                hydrogenPrice,
                energyPrice,
                level, 
                coef_modifier,
                timeSearch,
                timeToStart,
                isDone);

        technologieRepository.save(technologie);
    }

    public ResponseEntity<String> delete(String name) {
        technologieRepository.deleteByName(name);
        return new ResponseEntity<String>("Player successfully deleted!", HttpStatus.OK);
    }

    public List<TechnologiePayload> getTechnologies() {
        var techPayload = new ArrayList<TechnologiePayload>();
        List<Technologie> technologieList = technologieRepository.findAll();
        for (var technologie : technologieList) {

            var newTechnologie = new TechnologiePayload();

            newTechnologie.setName(technologie.getName());
            newTechnologie.setDescription(technologie.getDescription());

            newTechnologie.setIronPrice(technologie.getIronPrice());
            newTechnologie.setDiamondPrice(technologie.getDiamondPrice());
            newTechnologie.setHydrogenPrice(technologie.getHydrogenPrice());
            newTechnologie.setEnergyPrice(technologie.getEnergyPrice());
            
            
            newTechnologie.setLevel(technologie.getLevel());
            newTechnologie.setCoef_modifier(technologie.getCoef_modifier());
            
            newTechnologie.setTimeSearch(technologie.getTimeSearch());
            newTechnologie.setTimeToStart(technologie.getTimeToStart());

            newTechnologie.setDone(technologie.isDone());

            techPayload.add(newTechnologie);
        }
        return techPayload;
    }

    // // public ResponseEntity<TechnologiePayload> getThisTechnologie(String name){
    // public boolean getThisTechnologie(String name) {
    //     if (technologieRepository.findByName(name) != null)
    //         return true;
    //     else
    //         return false;
    //     // return new ResponseEntity<TechnologiePayload>("Technologie find ",
    //     // HttpStatus.OK);
   // }

    public void updateTechnologie(String name, TechnologiePayload technologie) throws Exception {
        var technologieToUpdate = technologieRepository.findByName(name);

        if (technologieToUpdate == null) {
            throw new Exception(name + "does not exist.");
        }

        if (technologie.getName() != null) {
            technologieToUpdate.setName(technologie.getName());
        }
        if (technologie.getDescription() != null) {
            technologieToUpdate.setDescription(technologie.getDescription());
        }

        if (technologie.getIronPrice() != 0) {
            technologieToUpdate.setIronPrice(technologie.getIronPrice());
        }
        if (technologie.getDiamondPrice() != 0) {
            technologieToUpdate.setDiamondPrice(technologie.getDiamondPrice());
        }
        if (technologie.getHydrogenPrice() != 0) {
            technologieToUpdate.setHydrogenPrice(technologie.getHydrogenPrice());
        }
        if (technologie.getEnergyPrice() != 0) {
            technologieToUpdate.setEnergyPrice(technologie.getEnergyPrice());
        }

        if (technologie.getLevel() != 0) {
            technologieToUpdate.setLevel(technologie.getLevel());
        }
        if (technologie.getCoef_modifier() != 0) {
            technologieToUpdate.setCoef_modifier(technologie.getCoef_modifier());
        }

        if (technologie.getTimeSearch() == null) {
            technologieToUpdate.setTimeSearch(technologie.getTimeSearch());
        }
        if (technologie.getTimeToStart() == null) {
            technologieToUpdate.setTimeToStart(technologie.getTimeToStart());
        }

        technologieToUpdate.setDone(technologie.isDone());

        technologieRepository.save(technologieToUpdate);

    }

}
