package com.clubmatrix.crud.dto;

public class LoginRequestDTO {
  public final String email;
  public final String password;

  public LoginRequestDTO(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
