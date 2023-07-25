package com.templateproject.api.service;

import com.templateproject.api.entity.Technologie;
import com.templateproject.api.repository.TechnologieRepository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
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

    public List<HashMap<String, String>> getAll(){
        var techPayload = new ArrayList<HashMap<String, String>>();

        List<Technologie> technologieList = technologieRepository.findAll();
        for (var technologie: technologieList){

            var newStringTechnologie = new HashMap<String, String>();
            
            newStringTechnologie.put("name",technologie.getName());
            newStringTechnologie.put("description",technologie.getDescription());

            var newIntTechnologie = new HashMap<String, Integer>();
            
            newIntTechnologie.put("priceRessource1n",technologie.getPriceRessource1());
            newIntTechnologie.put("priceRessource2",technologie.getPriceRessource2());
            newIntTechnologie.put("priceRessource3",technologie.getPriceRessource3());
            newIntTechnologie.put("priceEnergy",technologie.getPriceEnergy());
            newIntTechnologie.put("lvl",technologie.getLvl());
            newIntTechnologie.put("timeSearch",technologie.getTimeSearch());


            newIntTechnologie.put("coef_modifier",technologie.getCoef_modifier());
            
            newIntTechnologie.put("isDone",technologie.isDone());

            techPayload.add(newTechnologie);
        } 
    }

}
