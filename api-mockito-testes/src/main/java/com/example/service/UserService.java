package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Método adicional de exemplo (opcional)
    public void deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.delete(id);
        } else {
            throw new IllegalArgumentException("Usuário não encontrado: " + id);
        }
    }
}