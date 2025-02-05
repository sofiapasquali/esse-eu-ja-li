package com.example.esseeujali.service;

import com.example.esseeujali.model.Book;
import com.example.esseeujali.model.Reading;
import com.example.esseeujali.model.Trophy;
import com.example.esseeujali.model.User;
import com.example.esseeujali.repository.BookRepository;
import com.example.esseeujali.repository.ReadingRepository;
import com.example.esseeujali.repository.TrophyRepository;
import com.example.esseeujali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReadingService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private ReadingRepository readingRepository;
    
    @Autowired
    private TrophyRepository trophyRepository;
    
    public String markBookAsRead(Long userId, Long bookId) throws Exception {
        User user = userRepository.findById(userId)
                        .orElseThrow(() -> new Exception("User not found"));
        Book book = bookRepository.findById(bookId)
                        .orElseThrow(() -> new Exception("Book not found"));
        
        // Verifica se o livro já foi marcado como lido
        if (readingRepository.findByUserAndBook(user, book).isPresent()) {
            return "Livro já marcado como lido.";
        }
        
        // Cria o registro de leitura
        Reading reading = new Reading(user, book, LocalDateTime.now());
        readingRepository.save(reading);
        
        // Cálculo de pontos: 1 ponto base + 1 ponto a cada 100 páginas (divisão inteira)
        int additionalPoints = book.getPages() / 100;
        int pointsEarned = 1 + additionalPoints;
        user.setTotalPoints(user.getTotalPoints() + pointsEarned);
        userRepository.save(user);
        
        // Verifica se o usuário completou um múltiplo de 5 leituras para o gênero do livro
        List<Reading> readingsForGenre = readingRepository.findByUserAndBook_Genre(user, book.getGenre());
        int countForGenre = readingsForGenre.size();
        if (countForGenre % 5 == 0) {
            String trophyDescription = "Leitor de " + book.getGenre();
            Trophy trophy = new Trophy(trophyDescription, LocalDateTime.now(), user);
            trophyRepository.save(trophy);
        }
        
        return "Livro marcado como lido. Pontos ganhos: " + pointsEarned;
    }
}
