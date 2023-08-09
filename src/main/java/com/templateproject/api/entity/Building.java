package com.templateproject.api.entity;

import java.util.*;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false, length = 50)
    private String name;
    @Column(length = 50)
    private String type;

    private Integer level;

    private String description;
    private int coeff_prod;
    private int ironPrice;
    private int diamondPrice;
    private int hydrogenPrice;
    private int priceEnergy;
    private int timeBuilding;
    
    //JOINT DECLARATION
    @ManyToOne //toSetUp 1.N-1.1
    @JoinColumn (name = "planet_id", nullable = false, referencedColumnName = "id")
    private Planet planet;

    @OneToOne//toProduce 0.1-1.1
    private Ressource ressource;

    @ManyToOne // toMake 1.N-O.N
    @JoinColumn(name="ship_id")
    private Ship ship;

    @ManyToMany(mappedBy="buildingsList")//toAcces 0.N-0.N
    private List<Technologie> technologies; 

    
    public Building() {
    };

    public Building(String name, String type, int level, int buildingSize, String description, int coeff_prod,
            int ironPrice, int diamondPrice, int hydrogenPrice
    ,
            int priceEnergy, int timeBuilding) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.description = description;
        this.coeff_prod = coeff_prod;
        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice
 = hydrogenPrice
;
        this.priceEnergy = priceEnergy;
        this.timeBuilding = timeBuilding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCoeff_prod() {
        return coeff_prod;
    }

    public void setCoeff_prod(Integer coeff_prod) {
        this.coeff_prod = coeff_prod;
    }

    public Integer getIronPrice() {
        return ironPrice;
    }

    public void setIronPrice(Integer ironPrice) {
        this.ironPrice = ironPrice;
    }

    public Integer getDiamondPrice() {
        return diamondPrice;
    }

    public void setDiamondPrice(Integer diamondPrice) {
        this.diamondPrice = diamondPrice;
    }

    public Integer getHydrogenPrice() {
        return hydrogenPrice;
    }

    public void setHydrogenPrice(Integer hydrogenPrice) {
        this.hydrogenPrice = hydrogenPrice;
    }

    public Integer getEnergyPrice() {
        return energyPrice;
    }

    public void setEnergyPrice(Integer energyPrice) {
        this.energyPrice = energyPrice;
    }

    public Date getTimeBuilding() {
        return timeBuilding;
    }

    public void setTimeBuilding(Date timeBuilding) {
        this.timeBuilding = timeBuilding;
    }

    public Date getTimeToStart() {
        return timeToStart;
    }

    public void setTimeToStart(Date timeToStart) {
        this.timeToStart = timeToStart;
    }

    // GETTER & SETTER to JOINT
    public Planet getPlanet(){
        return planet;
    }

    public void setPlanetIdByBuildings(Planet planet) {
        this.planet = planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public List<Technologie> getTechnologiesList() {
        return technologiesList;
    }

    public void setTechnologiesList(List<Technologie> technologiesList) {
        this.technologiesList = technologiesList;
    }

    public List<Ship> getShipsList() {
        return shipsList;
    }

    public void setShipsList(List<Ship> shipsList) {
        this.shipsList = shipsList;
    }
    
    
}
