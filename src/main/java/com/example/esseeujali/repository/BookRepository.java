package com.example.esseeujali.repository;

import com.example.esseeujali.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }
