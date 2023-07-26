package com.templateproject.api.service;

import com.templateproject.api.controller.payload.TechnologiePayload;
import com.templateproject.api.entity.Technologie;
import com.templateproject.api.repository.TechnologieRepository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TechnologieService {

    private final TechnologieRepository technologieRepository;

    
    public TechnologieService(TechnologieRepository technologieRepository) {
        this.technologieRepository = technologieRepository;
    }

    public void add(
            String name,
            int priceRessource1n,
            int priceRessource2,
            int priceRessource3,
            int priceEnergy,
            String description, //modif le typ var de description
            int lvl, 
            float coef_modifier,
            int timeSearch,
            boolean isDone
    ){
        //TODO CHECK PARAM
        
        var technologie = new Technologie(
            name,
            priceRessource1n,
            priceRessource2,
            priceRessource3,
            priceEnergy,
            description,
            lvl,
            coef_modifier,
            timeSearch,
            isDone);
        
        technologieRepository.save(technologie);        
    }

    public ResponseEntity<String> deleteTechnologieById(Integer id){
        technologieRepository.deleteById(id);
        return new ResponseEntity<String>("Player successfully deleted!", HttpStatus.OK);
    }

    public List<TechnologiePayload> getTechnologies(){
        var techPayload = new ArrayList<TechnologiePayload>();
        List<Technologie> technologieList = technologieRepository.findAll();
        for (var technologie: technologieList){

            var newTechnologie = new TechnologiePayload();
            
            newTechnologie.setName(technologie.getName());
            newTechnologie.setPriceRessource1(technologie.getPriceRessource1());
            newTechnologie.setPriceRessource2(technologie.getPriceRessource2());
            newTechnologie.setPriceRessource3(technologie.getPriceRessource3());
            newTechnologie.setPriceEnergy(technologie.getPriceEnergy());
            newTechnologie.setDescription(technologie.getDescription());
            newTechnologie.setLvl(technologie.getLvl());
            newTechnologie.setTimeSearch(technologie.getTimeSearch());
            newTechnologie.setCoef_modifier(technologie.getCoef_modifier());
            newTechnologie.setDone(technologie.isDone());

            techPayload.add(newTechnologie);
        }
        return techPayload; 
    }

    // public ResponseEntity<TechnologiePayload> getThisTechnologie(String name){
    //     technologieRepository.deleteByName(name);
    //     return new ResponseEntity<String>("Player successfully deleted!", HttpStatus.OK); 
    // }

    public void updateTechnologie(String name, TechnologiePayload technologie) throws Exception{
        var technologieToUpdate = technologieRepository.findByName(name);

        if (technologieToUpdate == null){
            throw new Exception(name + "does not exist.");
        }

        if (technologie.getName() != null) {
            technologieToUpdate.setName(technologie.getName());
        }

        if (technologie.getPriceRessource1() != 0 ){
            technologieToUpdate.setPriceRessource1(technologie.getPriceRessource1());
        }
        if (technologie.getPriceRessource2() != 0 ){
            technologieToUpdate.setPriceRessource2(technologie.getPriceRessource1());
        }
        if (technologie.getPriceRessource3() != 0 ){
            technologieToUpdate.setPriceRessource3(technologie.getPriceRessource1());
        }
        if (technologie.getPriceEnergy() != 0 ){
            technologieToUpdate.setPriceEnergy(technologie.getPriceEnergy());
        }

        if (technologie.getDescription() != null ){
            technologieToUpdate.setDescription(technologie.getDescription());
        }

        if (technologie.getLvl() != 0 ){
            technologieToUpdate.setLvl(technologie.getLvl());
        }
        
        if (technologie.getCoef_modifier() != 0 ){
            technologieToUpdate.setCoef_modifier(technologie.getCoef_modifier());
        }

        if (technologie.getTimeSearch() != 0 ){
            technologieToUpdate.setTimeSearch(technologie.getTimeSearch());
        }
        
        technologieToUpdate.setDone(technologie.isDone());
        
        technologieRepository.save(technologieToUpdate);

    }



}
