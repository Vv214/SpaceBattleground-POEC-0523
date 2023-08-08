package com.templateproject.api.controller.payload;

import java.util.List;

import com.templateproject.api.entity.Building;
import com.templateproject.api.entity.Player;

public class PlanetPayload {
    
    private String message;

    private String name;
    private Integer positionX;
    private Integer positionY;
    private Integer planetSize;

    //JOINT TB Attributes: 
    private Player player; 
    private List<Building> buildingList;  

    public PlanetPayload(){}

    public PlanetPayload(String message, String name, Integer positionX, Integer positionY,
            Integer planetSize, Player player, List <Building> buildingList) {
        this.message = message;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.planetSize = planetSize;
        this.player = player;
        this.buildingList = buildingList;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Integer getPlanetSize() {
        return planetSize;
    }

    public void setPlanetSize(Integer planetSize) {
        this.planetSize = planetSize;
    }

    public void set(String message, String name, Integer positionX, Integer positionY,
        Integer planetSize,Player player, List<Building> buildingsList) {
        this.message = message;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.planetSize = planetSize;
        this.player = player;
        this.buildingList = buildingsList;
        
    }

    //GETTER & SETTER JOINTS TB 

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    
    
}
