package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Player {

    //FIELS DATA BASE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false, length = 50)
    private String nickname;
    @Column(nullable = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = true)
    private Integer level;

    //JOINTS DECLARATION 
    @OneToMany (mappedBy ="player") // toColonise 1.N-1.1
    private List<Planet> planetsList; 

    //@OneToMany(mappedBy = "player")// toVisit 0.N-0.N 
    @ManyToMany
    @JoinTable(
        name = "player_planet_visit",
        joinColumns = @JoinColumn(name="player_id"),
        inverseJoinColumns = @JoinColumn(name="planet_id")
    )
    private List<Planet> planetsVisited; 

    @OneToOne(mappedBy = "player") // joint toSetUp 0.1-1.N
    private Clan clan;

    @OneToOne(mappedBy="player") //toOwn 1.1-0.1
    private Admin admin;

    @OneToMany(mappedBy = "player") //toOrder O.N-1.1
    private List<Fleet> fleetsList; 

    public Player() {
        this.level = 1;
    };

    public Player(String nickname, String passwordHashed, String email) {
        this.nickname = nickname;
        this.password = passwordHashed;
        this.email = email;
        this.level = 1;
    }

    public Player(String nickname, String email, String password, Integer level) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.level = level;
    }
    
    //GETTERS & SETTERS

    public Player(String playerName) {
        this.nickname = playerName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    
    //GETTER & SETTER to JOINTS 
    public List<Planet> getPlanetsList() {
        return planetsList;
    }

    public void setPlanetsList(List<Planet> planetsList) {
        this.planetsList = planetsList;
    }

    public List<Planet> getPlanetsVisited() {
        return planetsVisited;
    }

    public void setPlanetsVisited(List<Planet> planetsVisited) {
        this.planetsVisited = planetsVisited;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Fleet> getFleetsList() {
        return fleetsList;
    }

    public void setFleetsList(List<Fleet> fleetsList) {
        this.fleetsList = fleetsList;
    }

}
