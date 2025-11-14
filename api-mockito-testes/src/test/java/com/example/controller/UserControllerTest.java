package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserSuccess() {
        User user = new User(1L, "Roberto");
        when(userService.getUserById(1L)).thenReturn(user);

        User result = userController.getUser(1L);

        assertNotNull(result);
        assertEquals("Roberto", result.getName());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void testGetUserNotFound() {
        when(userService.getUserById(2L))
                .thenThrow(new IllegalArgumentException("Usuário não encontrado: 2"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userController.getUser(2L);
        });

        assertEquals("Usuário não encontrado: 2", exception.getMessage());
        verify(userService, times(1)).getUserById(2L);
    }

    @Test
    void testCreateUser() {
        User user = new User(3L, "Alice");
        when(userService.createUser(user)).thenReturn(user);

        User result = userController.createUser(user);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(userService, times(1)).createUser(user);
    }
}


