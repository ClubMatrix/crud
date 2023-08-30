package com.clubmatrix.crud.repositories;

import com.clubmatrix.crud.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
