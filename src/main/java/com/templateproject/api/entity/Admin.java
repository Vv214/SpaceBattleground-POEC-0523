package com.templateproject.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 50)
    private String name;

    private boolean createPlayer; 
    private boolean removPlayer;
    private boolean createPlanet;
    private boolean removePlanet; 
    private boolean giveRessources; 
    private boolean removeRessources;
    private boolean createBuilding; 
    private boolean removeBuilding; 
    private boolean giveClan; 
    private boolean removeClan;
    private boolean addToClan;
    private boolean deleteToClan;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isCreatePlayer() {
        return createPlayer;
    }
    public void setCreatePlayer(boolean createPlayer) {
        this.createPlayer = createPlayer;
    }
    public boolean isRemovPlayer() {
        return removPlayer;
    }
    public void setRemovPlayer(boolean removPlayer) {
        this.removPlayer = removPlayer;
    }
    public boolean isCreatePlanet() {
        return createPlanet;
    }
    public void setCreatePlanet(boolean createPlanet) {
        this.createPlanet = createPlanet;
    }
    public boolean isRemovePlanet() {
        return removePlanet;
    }
    public void setRemovePlanet(boolean removePlanet) {
        this.removePlanet = removePlanet;
    }
    public boolean isGiveRessources() {
        return giveRessources;
    }
    public void setGiveRessources(boolean giveRessources) {
        this.giveRessources = giveRessources;
    }
    public boolean isRemoveRessources() {
        return removeRessources;
    }
    public void setRemoveRessources(boolean removeRessources) {
        this.removeRessources = removeRessources;
    }
    public boolean isCreateBuilding() {
        return createBuilding;
    }
    public void setCreateBuilding(boolean createBuilding) {
        this.createBuilding = createBuilding;
    }
    public boolean isRemoveBuilding() {
        return removeBuilding;
    }
    public void setRemoveBuilding(boolean removeBuilding) {
        this.removeBuilding = removeBuilding;
    }
    public boolean isGiveClan() {
        return giveClan;
    }
    public void setGiveClan(boolean giveClan) {
        this.giveClan = giveClan;
    }
    public boolean isRemoveClan() {
        return removeClan;
    }
    public void setRemoveClan(boolean removeClan) {
        this.removeClan = removeClan;
    }
    public boolean isAddToClan() {
        return addToClan;
    }
    public void setAddToClan(boolean addToClan) {
        this.addToClan = addToClan;
    }
    public boolean isDeleteToClan() {
        return deleteToClan;
    }
    public void setDeleteToClan(boolean deleteToClan) {
        this.deleteToClan = deleteToClan;
    }


   
}
