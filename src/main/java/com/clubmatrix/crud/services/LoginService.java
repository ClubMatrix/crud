package com.clubmatrix.crud.services;

import com.clubmatrix.crud.dto.LoginRequestDTO;
import com.clubmatrix.crud.dto.LoginResponseDTO;
import com.clubmatrix.crud.dto.RegisterRequestDTO;
import com.clubmatrix.crud.dto.RegisterResponseDTO;
import com.clubmatrix.crud.exceptions.DuplicateRecordException;
import com.clubmatrix.crud.exceptions.AuthenticationFailedException;
import com.clubmatrix.crud.models.Login;
import com.clubmatrix.crud.repositories.LoginRepository;
import com.clubmatrix.crud.utils.AuthUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  @Autowired
  private LoginRepository loginRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private AuthUtil authUtil;

  public LoginResponseDTO authenticate(LoginRequestDTO loginRequest) {
    Login storedLogin = loginRepository.findByEmail(loginRequest.email);
    if (storedLogin != null && passwordEncoder.matches(loginRequest.password, storedLogin.getPassword())) {
      String token = authUtil.generateToken(storedLogin);
      return new LoginResponseDTO(token);
    }
    throw new AuthenticationFailedException("Invalid email or password.");
  }

  public RegisterResponseDTO register(RegisterRequestDTO registerRequest) {
    if (loginRepository.findByEmail(registerRequest.email) != null) {
      throw new DuplicateRecordException("Email already registered.");
    }
    Login newLogin = new Login(registerRequest.name, registerRequest.email,
        passwordEncoder.encode(registerRequest.password), registerRequest.phone, null);
    Login registeredLogin = saveLogin(newLogin);
    return new RegisterResponseDTO(registeredLogin.getId(), registeredLogin.getName(), registeredLogin.getEmail());
  }

  public Login saveLogin(Login login) {
    return loginRepository.save(login);
  }
}
