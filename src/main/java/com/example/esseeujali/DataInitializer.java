package com.example.esseeujali;

import com.example.esseeujali.model.Book;
import com.example.esseeujali.model.User;
import com.example.esseeujali.repository.BookRepository;
import com.example.esseeujali.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Criação de alguns usuários
        User user1 = new User("Alice", "alice@example.com", "password123");
        User user2 = new User("Bob", "bob@example.com", "password456");
        userRepository.save(user1);
        userRepository.save(user2);
        
        // Criação de alguns livros
        Book book1 = new Book("Book One", "Author A", 72, "Ficção Científica", "Resumo do Book One");
        Book book2 = new Book("Book Two", "Author B", 124, "Romance", "Resumo do Book Two");
        Book book3 = new Book("Book Three", "Author C", 350, "Ficção Científica", "Resumo do Book Three");
        Book book4 = new Book("Book Four", "Author D", 200, "Mistério", "Resumo do Book Four");
        Book book5 = new Book("Book Five", "Author E", 180, "Ficção Científica", "Resumo do Book Five");
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
    }
}
