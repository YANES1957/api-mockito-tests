package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserByIdFound() {
        User user = new User(1L, "Roberto");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Roberto", result.getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserByIdNotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.getUserById(2L);
        });

        assertEquals("Usuário não encontrado: 2", exception.getMessage());
        verify(userRepository, times(1)).findById(2L);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void testGetUserByIdParameterized(long id) {
        User user = new User(id, "User" + id);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        User result = userService.getUserById(id);

        assertEquals("User" + id, result.getName());
        verify(userRepository, times(1)).findById(id);
    }
}
