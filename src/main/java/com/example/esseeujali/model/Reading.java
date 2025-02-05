package com.example.esseeujali.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reading {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Book book;
    
    private LocalDateTime readAt;
    
    public Reading() { }
    
    public Reading(User user, Book book, LocalDateTime readAt) {
        this.user = user;
        this.book = book;
        this.readAt = readAt;
    }

    // Getters e setters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public Book getBook() { return book; }
    public LocalDateTime getReadAt() { return readAt; }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setBook(Book book) { this.book = book; }
    public void setReadAt(LocalDateTime readAt) { this.readAt = readAt; }
}
