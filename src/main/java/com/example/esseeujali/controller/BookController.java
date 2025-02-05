package com.example.esseeujali.controller;

import com.example.esseeujali.model.Book;
import com.example.esseeujali.repository.BookRepository;
import com.example.esseeujali.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private ReadingService readingService;
    
    // Lista todos os livros
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    // Detalhes de um livro
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) throws Exception {
        return bookRepository.findById(id)
            .orElseThrow(() -> new Exception("Livro não encontrado"));
    }
    
    // Marca um livro como lido (envie o parâmetro userId)
    @PostMapping("/{id}/mark-read")
    public String markBookAsRead(@PathVariable Long id, @RequestParam Long userId) {
        try {
            return readingService.markBookAsRead(userId, id);
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}
