package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;




@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column( unique = true, nullable = false, length = 50)
    private String name;
    private Integer positionX;
    private Integer positionY;
    private Integer planetSize;

    //JOINT DECLARATION
    @ManyToOne //toColonise 1.N-1.1
    @JoinColumn(name = "player_id", nullable = true, referencedColumnName = "id")
    private Player player;

    @OneToMany (mappedBy = "planet") //toVisit O.N-O.N >> ?? table de jonction ??
    private List<Player> playerVisit; 

    @OneToMany (mappedBy = "building") //toSetUpJoint 1.N
    private List<Building> buildingsList; 

    @OneToMany(mappedBy = "ressource") //toStoreJoint 1.N
    private List<Ressource> ressourcesList;

    @OneToMany(mappedBy = "planet_id") //toPark O.N-O.N
    private List<Fleet> fleetsList;

    //JOINT DECLARATION 
    @ManyToOne //toColonize 1.N-1.1
    @JoinColumn(name="player_id", nullable=true,referencedColumnName = "id")
    private Player player;

    //@OneToMany (mappedBy = "player")// toVisit 0.N-0.N 
    @ManyToMany(mappedBy = "planetsVisited")
    private List<Player> playersWhoVisited;

    @ManyToMany  //toStore 0.N-1.N
    @JoinTable(
        name ="planet_ressource_toStore",
        joinColumns = @JoinColumn(name = "planet_id"),
        inverseJoinColumns =  @JoinColumn(name="ressource_id"))
    private List<Ressource> ressourcesList;

    @OneToMany (mappedBy = "planet") //toSetUp 1.N-0.1
    private List<Building> buildingsList;

    @ManyToMany (mappedBy="parkedPlanets") //toPark O.N-O.N
    private List<Fleet> parkFleets;
    
    //CONSTRUCTORS
    public Planet() {};

    public Planet(String name, Integer positionX, Integer positionY, Integer planetSize, Player player, List<Building> buildingsList) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.planetSize = planetSize;
        this.player = player;
        this.buildingsList = buildingsList; 
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

    //GETTER & SETTER to JOINTS
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Player> getPlayersWhoVisited() {
        return playersWhoVisited;
    }

    public void setPlayersWhoVisited(List<Player> playersWhoVisited) {
        this.playersWhoVisited = playersWhoVisited;
    }

    public List<Ressource> getRessourcesList() {
        return ressourcesList;
    }

    public void setRessourcesList(List<Ressource> ressourcesList) {
        this.ressourcesList = ressourcesList;
    }

    public List<Building> getBuildingsList() {
        return buildingsList;
    }

    public void setBuildingsList(List<Building> buildingsList) {
        this.buildingsList = buildingsList;
    }

    public List<Fleet> getParkFleets() {
        return parkFleets;
    }

    public void setParkFleets(List<Fleet> parkFleets) {
        this.parkFleets = parkFleets;
    }

    


    
}
