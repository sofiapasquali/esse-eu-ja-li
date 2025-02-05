package com.example.esseeujali.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String author;
    private int pages;
    private String genre;
    @Column(length = 1000)
    private String summary;

    public Book() { }

    public Book(String title, String author, int pages, String genre, String summary) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
        this.summary = summary;
    }

    // Getters e setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public String getGenre() { return genre; }
    public String getSummary() { return summary; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPages(int pages) { this.pages = pages; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setSummary(String summary) { this.summary = summary; }
}
