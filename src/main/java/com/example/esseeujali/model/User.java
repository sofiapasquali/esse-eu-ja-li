package com.example.esseeujali.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // Alterado de "user" para "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private int totalPoints;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Trophy> trophies = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reading> readings = new ArrayList<>();

    public User() { }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.totalPoints = 0;
    }

    // Getters e setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getTotalPoints() { return totalPoints; }
    public List<Trophy> getTrophies() { return trophies; }
    public List<Reading> getReadings() { return readings; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setTotalPoints(int totalPoints) { this.totalPoints = totalPoints; }
    public void setTrophies(List<Trophy> trophies) { this.trophies = trophies; }
    public void setReadings(List<Reading> readings) { this.readings = readings; }
}
