package com.templateproject.api.service;

import com.templateproject.api.controller.payload.TechnologiePayload;
import com.templateproject.api.entity.Technologie;
import com.templateproject.api.repository.TechnologieRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologieService {

    private final TechnologieRepository technologieRepository;

    
    public TechnologieService(TechnologieRepository technologieRepository) {
        this.technologieRepository = technologieRepository;
    }

    public void add(
            String name,
            int ironPrice,
            int DiamondPrice,
            int HydrogenPrice,
            int priceEnergy,
            String description,
            int lvl, 
            float coef_modifier,
            int timeSearch,
            boolean isDone
    ){
        //TODO CHECK PARAM
        
        var technologie = new Technologie(
            name,
            ironPrice,
            DiamondPrice,
            HydrogenPrice,
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
            newTechnologie.setIronPrice(technologie.getIronPrice());
            newTechnologie.setDiamondPrice(technologie.getDiamondPrice());
            newTechnologie.setHydrogenPrice(technologie.getydrogenPrice());
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

        if (technologie.getIronPrice() != 0 ){
            technologieToUpdate.setIronPrice(technologie.getIronPrice());
        }
        if (technologie.getDiamondPrice() != 0 ){
            technologieToUpdate.setDiamondPrice(technologie.getDiamondPrice());
        }
        if (technologie.getHydrogenPrice() != 0 ){
            technologieToUpdate.setHydrogenPrice(technologie.getHydrogenPrice());
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
