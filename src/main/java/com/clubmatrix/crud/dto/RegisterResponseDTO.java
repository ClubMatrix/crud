package com.clubmatrix.crud.dto;

public class RegisterResponseDTO {
  public final Long id;
  public final String name;
  public final String email;

  public RegisterResponseDTO(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }
}
