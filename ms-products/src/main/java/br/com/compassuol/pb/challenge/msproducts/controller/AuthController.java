package br.com.compassuol.pb.challenge.msproducts.controller;

import br.com.compassuol.pb.challenge.msproducts.dto.JwtAuthResponse;
import br.com.compassuol.pb.challenge.msproducts.dto.LoginDto;
import br.com.compassuol.pb.challenge.msproducts.dto.RegisterDto;
import br.com.compassuol.pb.challenge.msproducts.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<RegisterDto> getUserById(@PathVariable(name = "id")long id){
        return ResponseEntity.ok(authService.getUserById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<RegisterDto> updateUser(@RequestBody RegisterDto registerDto, @PathVariable(name = "id") long id){
        RegisterDto userResponse = authService.updateUser(registerDto, id);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
