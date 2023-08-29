package com.clubmatrix.crud.controllers;

import com.clubmatrix.crud.dto.LoginRequestDTO;
import com.clubmatrix.crud.dto.LoginResponseDTO;
import com.clubmatrix.crud.dto.RegisterRequestDTO;
import com.clubmatrix.crud.dto.RegisterResponseDTO;
import com.clubmatrix.crud.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO response = loginService.authenticate(loginRequest);

        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>("Invalid email or password.", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequest) {
        RegisterResponseDTO response = loginService.register(registerRequest);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Email already registered or registration failed.", HttpStatus.BAD_REQUEST);
    }
}
