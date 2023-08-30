package com.clubmatrix.crud.dto;

import com.clubmatrix.crud.models.Member;

public class MemberRequestDTO {
  public final String name;
  public final String email;
  public final String password;
  public final String phone;
  public final String street;
  public final String city;
  public final String state;
  public final String postalCode;
  public final String country;
  public final Member.PaymentDetails paymentDetails;

  public MemberRequestDTO(String name, String email, String password, String phone, String street, String city,
      String state, String postalCode, String country, Member.PaymentDetails paymentDetails) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.street = street;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;
    this.paymentDetails = paymentDetails;
  }
}
