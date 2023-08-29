package com.clubmatrix.crud.controllers;

import com.clubmatrix.crud.models.Login;
import com.clubmatrix.crud.services.LoginService;
import com.clubmatrix.crud.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        Login storedLogin = loginService.findByEmail(login.getEmail());
        if (storedLogin != null && passwordEncoder.matches(login.getPassword(), storedLogin.getPassword())) {
            String token = authUtil.generateToken(storedLogin);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid email or password.", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Login login) {
        if (loginService.findByEmail(login.getEmail()) != null) {
            return new ResponseEntity<>("Email already registered.", HttpStatus.BAD_REQUEST);
        }
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        Login registeredLogin = loginService.saveLogin(login);
        if (registeredLogin != null) {
            return new ResponseEntity<>(registeredLogin, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Registration failed.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
