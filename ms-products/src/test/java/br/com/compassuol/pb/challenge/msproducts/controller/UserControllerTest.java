package br.com.compassuol.pb.challenge.msproducts.controller;

import br.com.compassuol.pb.challenge.msproducts.dto.LoginDto;
import br.com.compassuol.pb.challenge.msproducts.dto.RegisterDto;
import br.com.compassuol.pb.challenge.msproducts.entity.User;
import br.com.compassuol.pb.challenge.msproducts.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.HashSet;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;
    private RegisterDto responseUser;


    private User user;
    private LoginDto loginDto;

    @BeforeEach
    void setup() {
        user = new User(1L, "Teste", "Teste", "teste@gmail.com", "teste", new HashSet<>());
        responseUser = userService.getUserById(1L);
    }


    @Test
    void register() {
        var response = assertDoesNotThrow(() -> userController.register(responseUser));
        assertEquals(userController.register(responseUser), response);
    }

    @Test
    void getUserById() {
        when(userService.getUserById(1L)).thenReturn(responseUser);
        var response = assertDoesNotThrow(() -> userController.getUserById(1L));
        assertEquals(userController.getUserById(1L), response);
    }

    @Test
    void updateUser() {
        var response = assertDoesNotThrow(() -> userController.updateUser(responseUser, 1L));
        assertEquals(userController.updateUser(responseUser, 1L), response);
    }
}