package com.clubmatrix.crud.dto;

import com.clubmatrix.crud.models.Address;

public class RegisterRequestDTO {
  public final String name;
  public final String email;
  public final String password;
  public final String phone;
  public final Address address;

  public RegisterRequestDTO(String name, String email, String password, String phone, Address address) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.address = address;
  }
}
