package com.templateproject.api.controller.payload;

public class PlanetPayload {
    
    private String message;

    private String name;
    private  boolean isColonised;
    private  Integer positionX;
    private  Integer positionY;
    private  Integer planetSize;

    public PlanetPayload(){}

    public PlanetPayload(String message, String name, boolean isColonised, Integer positionX, Integer positionY,
            Integer planetSize) {
        this.message = message;
        this.name = name;
        this.isColonised = isColonised;
        this.positionX = positionX;
        this.positionY = positionY;
        this.planetSize = planetSize;
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

    public boolean isColonised() {
        return isColonised;
    }

    public void setColonised(boolean isColonised) {
        this.isColonised = isColonised;
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

    public void set(String message, String name, boolean isColonised, Integer positionX, Integer positionY,
            Integer planetSize) {
        this.message = message;
        this.name = name;
        this.isColonised = isColonised;
        this.positionX = positionX;
        this.positionY = positionY;
        this.planetSize = planetSize;
    }
    

}
