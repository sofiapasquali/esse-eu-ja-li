package com.example.esseeujali.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Trophy {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    
    private LocalDateTime earnedAt;
    
    @ManyToOne
    private User user;
    
    public Trophy() { }
    
    public Trophy(String description, LocalDateTime earnedAt, User user) {
        this.description = description;
        this.earnedAt = earnedAt;
        this.user = user;
    }

    // Getters e setters
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public LocalDateTime getEarnedAt() { return earnedAt; }
    public User getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setEarnedAt(LocalDateTime earnedAt) { this.earnedAt = earnedAt; }
    public void setUser(User user) { this.user = user; }
}
