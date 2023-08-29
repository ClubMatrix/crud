package com.clubmatrix.crud.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class HashPasswordUtil {
  public static String hashPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }
}
