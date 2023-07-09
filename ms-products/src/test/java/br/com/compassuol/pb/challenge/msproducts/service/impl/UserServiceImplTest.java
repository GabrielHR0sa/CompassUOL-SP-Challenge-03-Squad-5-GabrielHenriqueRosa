package br.com.compassuol.pb.challenge.msproducts.service.impl;

import br.com.compassuol.pb.challenge.msproducts.dto.JwtAuthResponse;
import br.com.compassuol.pb.challenge.msproducts.dto.LoginDto;
import br.com.compassuol.pb.challenge.msproducts.dto.RegisterDto;
import br.com.compassuol.pb.challenge.msproducts.entity.Role;
import br.com.compassuol.pb.challenge.msproducts.entity.User;
import br.com.compassuol.pb.challenge.msproducts.exception.ResourceNotFoundException;
import br.com.compassuol.pb.challenge.msproducts.repository.RoleRepository;
import br.com.compassuol.pb.challenge.msproducts.repository.UserRepository;
import br.com.compassuol.pb.challenge.msproducts.security.JwtTokenProvider;
import br.com.compassuol.pb.challenge.msproducts.service.UserService;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtTokenProvider jwtTokenProvider;
    @Mock
    private RabbitTemplate rabbitTemplate;

    @Mock
    private RegisterDto registerDto;

    @InjectMocks
    private UserService userService = new UserServiceImpl(authenticationManager, userRepository, roleRepository, passwordEncoder, jwtTokenProvider,rabbitTemplate);

//    @Test
//    void login() {
//        User user = new User(1L, "Teste", "Teste", "teste@gmail.com","teste", new HashSet<>());
//        when(userRepository.save(any(User.class))).thenReturn(user);
//        String addRegister = userService.login(new LoginDto());
//        verify(userRepository).save(any(User.class));
//        assertThat(addRegister).isNotNull();
//    }

//    @Test
//    void register() {
//        User user = new User(1L, "Teste", "Teste", "teste@gmail.com","teste", new HashSet<>());
//        when(userRepository.save(any(User.class))).thenReturn(user);
//        String addRegister = userService.register(new RegisterDto());
//        verify(userRepository).save(any(User.class));
//        assertThat(addRegister).isNotNull();
//    }

    @Test
    void getUserById() {

        User user = new User(1L, "Teste", "Teste", "teste@gmail.com","teste", new HashSet<>());
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        RegisterDto foundUser = userService.getUserById(1L);
        assertThat(foundUser).isNotNull();
        verify(userRepository).findById(1L);
    }

//    @Test
//    void updateUser() {
//        User user = new User();
//        user.setId(2L);
//        when(userRepository.findById(2L)).thenReturn(Optional.of(user));
//        RegisterDto updateUser = userService.updateUser(registerDto,2L);
//        verify(userRepository).save(any(User.class));
//        assertThat(updateUser).isNotNull();
//
//    }
}