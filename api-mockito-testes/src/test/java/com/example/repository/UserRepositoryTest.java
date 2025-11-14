package com.example.repository;

import com.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    void testSaveAndFindById() {
        User user = new User(1L, "Roberto");
        userRepository.save(user);

        Optional<User> found = userRepository.findById(1L);

        assertTrue(found.isPresent(), "Usuário deveria ser encontrado");
        assertEquals("Roberto", found.get().getName());
    }

    @Test
    void testFindByIdNotFound() {
        Optional<User> found = userRepository.findById(999L);
        assertTrue(found.isEmpty(), "Usuário não deveria ser encontrado");
    }

    @Test
    void testDeleteUser() {
        User user = new User(2L, "Alice");
        userRepository.save(user);

        // Verifica se existe
        assertTrue(userRepository.findById(2L).isPresent());

        // Deleta o usuário
        userRepository.delete(2L);

        // Agora não deve existir
        assertTrue(userRepository.findById(2L).isEmpty());
    }
}
