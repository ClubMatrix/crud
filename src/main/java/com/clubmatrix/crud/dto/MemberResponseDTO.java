package com.clubmatrix.crud.dto;

import com.clubmatrix.crud.models.Member;

public class MemberResponseDTO {
  public final Long id;
  public final String name;
  public final String email;
  public final String phone;
  public final String street;
  public final String city;
  public final String state;
  public final String postalCode;
  public final String country;
  public final Member.PaymentDetails paymentDetails;
  public final Member.Status status;

  public MemberResponseDTO(Long id, String name, String email, String phone, String street, String city, String state,
      String postalCode, String country, Member.PaymentDetails paymentDetails, Member.Status status) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.street = street;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;
    this.paymentDetails = paymentDetails;
    this.status = status;
  }
}
