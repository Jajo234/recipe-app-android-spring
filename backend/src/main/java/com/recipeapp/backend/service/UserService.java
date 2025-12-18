package com.recipeapp.backend.service;

import com.recipeapp.backend.model.User;
import com.recipeapp.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String email, String password) {

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already registered");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
