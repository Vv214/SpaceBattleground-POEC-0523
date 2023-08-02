package com.templateproject.api.service;

import com.templateproject.api.controller.payload.TechnologiePayload;
import com.templateproject.api.entity.Technologie;
import com.templateproject.api.repository.TechnologieRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class TechnologieService {

    private final TechnologieRepository technologieRepository;

    public TechnologieService(TechnologieRepository technologieRepository) {
        this.technologieRepository = technologieRepository;
    }
//CREATE ONE
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

    //RESEARCH ALL
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
    //RESEARCH ONE
     public HashMap<String, Object> getTechnologie(String name){
        var technologie = new HashMap<String, Object>();

        var technologieEntity = technologieRepository.findByName(name);
            technologie.put("Description(s): ",technologieEntity.getDescription());
                        
            technologie.put("Iron Price: ",technologieEntity.getIronPrice());
            technologie.put("Diamond Price: ",technologieEntity.getDiamondPrice());
            technologie.put("Hydrogen Price: ",technologieEntity.getHydrogenPrice());
            technologie.put("Energy Price: ",technologieEntity.getEnergyPrice());
          
            technologie.put("Level: ",technologieEntity.getLevel());
            technologie.put("Coefficient Mood: ",technologieEntity.getCoef_modifier());
           
            technologie.put("Time to Research: ",technologieEntity.getTimeSearch());
            technologie.put("Date to Strat Research: ",technologieEntity.getTimeToStart());

            technologie.put("Technologie Statut",technologieEntity.isDone());
            return technologie; 
     }

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


//DELETE ONE
    public ResponseEntity<String> delete(String name) {
        technologieRepository.deleteByName(name);
        return new ResponseEntity<String>("Player successfully deleted!", HttpStatus.OK);
    }


}
