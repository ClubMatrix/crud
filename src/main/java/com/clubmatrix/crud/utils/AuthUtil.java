package com.clubmatrix.crud.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.clubmatrix.crud.models.Permission;
import com.clubmatrix.crud.models.Role;
import com.clubmatrix.crud.models.User;

public class AuthUtil {
    private final String SECRET_KEY = System.getenv("CLUB_MATRIX_SECRET_KEY");
    private final Algorithm ALGORITHM = Algorithm.HMAC512(SECRET_KEY);

    public String generateToken(User user) {
        String jwt = JWT.create()
            .withSubject(user.getEmail())
            .withExpiresAt(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
            .sign(ALGORITHM);

        return jwt;
    }

    public boolean validateToken(String token) {
        try {
            JWT.require(ALGORITHM).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasPermission(User user, String requiredPermission) {
        for (Role role : user.getRoles()) {
            for (Permission permission : role.getPermissions()) {
                if (permission.getName().equals(requiredPermission)) {
                    return true;
                }
            }
        }

        for (Permission permission : user.getPermissions()) {
            if (permission.getName().equals(requiredPermission)) {
                return true;
            }
        }

        return false;
    }
}
