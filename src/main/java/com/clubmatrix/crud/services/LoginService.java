package com.clubmatrix.crud.services;

import com.clubmatrix.crud.models.Login;
import com.clubmatrix.crud.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  @Autowired
  private LoginRepository loginRepository;

  public Login findByEmail(String email) {
    return loginRepository.findByEmail(email);
  }

  public Login saveLogin(Login login) {
    return loginRepository.save(login);
  }
}
