package com.example.esseeujali.controller;

import com.example.esseeujali.model.User;
import com.example.esseeujali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                // Para simplificar, retorna o ID do usuário como "token"
                return "Login bem-sucedido. Seu user id é: " + user.getId();
            } else {
                return "Senha inválida.";
            }
        } else {
            return "Usuário não encontrado.";
        }
    }
}
