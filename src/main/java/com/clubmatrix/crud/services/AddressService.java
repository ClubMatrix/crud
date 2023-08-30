package com.clubmatrix.crud.services;

import com.clubmatrix.crud.models.Address;
import com.clubmatrix.crud.repositories.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  @Autowired
  private AddressRepository addressRepository;

  public Address saveAddress(Address address) {
    return addressRepository.save(address);
  }
}
