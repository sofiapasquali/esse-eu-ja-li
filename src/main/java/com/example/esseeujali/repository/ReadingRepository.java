package com.example.esseeujali.repository;

import com.example.esseeujali.model.Reading;
import com.example.esseeujali.model.User;
import com.example.esseeujali.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
    Optional<Reading> findByUserAndBook(User user, Book book);
    List<Reading> findByUser(User user);
    List<Reading> findByUserAndBook_Genre(User user, String genre);
}
