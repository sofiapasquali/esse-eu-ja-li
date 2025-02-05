package com.example.esseeujali.controller;

import com.example.esseeujali.model.User;
import com.example.esseeujali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    public User getProfile(@RequestParam Long userId) throws Exception {
        return userRepository.findById(userId)
            .orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
}
