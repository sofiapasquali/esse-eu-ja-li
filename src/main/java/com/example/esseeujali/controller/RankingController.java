package com.example.esseeujali.controller;

import com.example.esseeujali.model.User;
import com.example.esseeujali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {

    @Autowired
    private UserRepository userRepository;
    
    // Retorna os 10 usuários com maior pontuação
    @GetMapping
    public List<User> getRanking() {
        return userRepository.findAll(
            PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "totalPoints"))
        ).getContent();
    }
}
