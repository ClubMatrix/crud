package com.clubmatrix.crud.dto;

public class RegisterRequestDTO {
  public final String name;
  public final String email;
  public final String password;
  public final String phone;

  public RegisterRequestDTO(String name, String email, String password, String phone) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
  }
}
