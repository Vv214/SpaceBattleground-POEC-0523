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
            string description, //modif le typ var de description
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
        var payload = new ArrayList<HashMap<String, String>();

        List<Technologie> technologieList = technologieRepository.findAll();
        for (var technologie: technologieList){
            var newTechnologie = new HashMap<String, String>();
            newTechnologie.put("name",technologie.getName());
            newTechnologie.put("priceRessource1n",technologie.getPriceRessource1());
            newTechnologie.put("priceRessource2",technologie.getPriceRessource2());
            newTechnologie.put("priceRessource3",technologie.getPriceRessource3());
            newTechnologie.put("priceEnergy",technologie.getPriceEnergy());
            newTechnologie.put("description",technologie.getDescription());
            newTechnologie.put("lvl",technologie.getLvl());
            newTechnologie.put("coef_modifier",technologie.getCoef_modifier());
            newTechnologie.put("timeSearch",technologie.getTimeSearch());
            newTechnologie.put("isDone",technologie.isDone());
            payload.add(newTechnologie);
        } 
    }

}
