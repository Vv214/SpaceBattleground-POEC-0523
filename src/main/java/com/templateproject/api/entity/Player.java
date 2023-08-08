package com.templateproject.api.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

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

    //JOINT DECLARATION
    @OneToMany (mappedBy = "player")
    private List<Planet> planets; 

    @OneToMany (mappedBy = "player") //toVisit O.N-O.N >> ?? table de jonction ??
    private List<Planet> planetsVisit; 
    
    @OneToMany(mappedBy = "player") //toOrder O.N-1.1
    private List<Fleet> fleetsList; 

    @OneToOne(mappedBy="player") //toOwn 1.1-0.1
    private Admin admin;

    @OneToOne(mappedBy = "player") // joint toSetUp 0.1-1.N
    private Clan clan;

    //CONSTUCTORS
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

    //GETER & SETTER to JOINT 
    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public List<Planet> getPlanetsVisit() {
        return planetsVisit;
    }

    public void setPlanetsVisit(List<Planet> planetsVisit) {
        this.planetsVisit = planetsVisit;
    }

    public List<Fleet> getFleetsList() {
        return fleetsList;
    }

    public void setFleetsList(List<Fleet> fleetsList) {
        this.fleetsList = fleetsList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    

}
