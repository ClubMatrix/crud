package com.clubmatrix.crud.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.clubmatrix.crud.models.Permission;
import com.clubmatrix.crud.models.Role;
import com.clubmatrix.crud.repositories.LoginRepository;
import com.clubmatrix.crud.models.Login;

@Component
public class AuthUtil {

    @Autowired
    private LoginRepository loginRepository;

    private final String SECRET_KEY = System.getenv("CLUB_MATRIX_SECRET_KEY");
    private final Algorithm ALGORITHM = Algorithm.HMAC512(SECRET_KEY);

    public AuthUtil() {
    }

    public Algorithm getAlgorithm() {
        return ALGORITHM;
    }

    public String generateToken(Login login) {
        String jwt = JWT.create()
                .withSubject(login.getEmail())
                .withExpiresAt(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .sign(ALGORITHM);

        return jwt;
    }

    public boolean validateToken(String token) {
        try {
            this.verifyToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DecodedJWT verifyToken(String token) {
        return JWT.require(ALGORITHM).build().verify(token);
    }

    public boolean hasPermission(String token, String requiredPermission) {
        String loginEmail = JWT.require(ALGORITHM).build().verify(token).getSubject();
        Login login = loginRepository.findByEmail(loginEmail);

        for (Role role : login.getRoles()) {
            for (Permission permission : role.getPermissions()) {
                if (permission.getName().equals(requiredPermission)) {
                    return true;
                }
            }
        }

        for (Permission permission : login.getPermissions()) {
            if (permission.getName().equals(requiredPermission)) {
                return true;
            }
        }

        return false;
    }
}
