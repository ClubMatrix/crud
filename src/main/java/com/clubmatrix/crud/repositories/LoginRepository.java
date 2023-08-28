package com.clubmatrix.crud.repositories;

import com.clubmatrix.crud.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
  public Login findByEmail(String email);
}
