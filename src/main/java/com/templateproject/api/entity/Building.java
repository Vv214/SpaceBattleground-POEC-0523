package com.templateproject.api.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;


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
    private Integer coeff_prod;

    private Integer ironPrice;
    private Integer diamondPrice;
    private Integer hydrogenPrice;
    private Integer energyPrice;
    

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBuilding;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeToStart;

    //JOINT DECLARATION
    @ManyToOne //tiSetUp Joint 1.1
    @JoinColumn (name = "planet_id", nullable = false, referencedColumnName = "id")
    private Planet planet;

    @OneToOne //toStore Joint 1.N-1.N
    @JoinColumn(name = "Ressoucre_id")
    private Ressource ressource;

    @OneToMany (mappedBy = "buildingsListByTechnologie") //Joint to Acces 0.N-0.N
    private List<Technologie> technologiesList; 

    @OneToMany (mappedBy = "buildingNecesseray") //Joints toCompose 0.N-0.N
    private List<Ship> shipsList; 
    
    //CONSTRUCTOR
    public Building(){};

    public Building(String name, String type, Integer level, String description, Integer coeff_prod, Integer ironPrice,
            Integer diamondPrice, Integer hydrogenPrice, Integer energyPrice, Date timeBuilding,
            Date timeToStart, Planet planet) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.description = description;
        this.coeff_prod = coeff_prod;
        this.ironPrice = ironPrice;
        this.diamondPrice = diamondPrice;
        this.hydrogenPrice = hydrogenPrice;
        this.energyPrice = energyPrice;
        this.timeBuilding = timeBuilding;
        this.timeToStart = timeToStart;
        this.planet = planet;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
