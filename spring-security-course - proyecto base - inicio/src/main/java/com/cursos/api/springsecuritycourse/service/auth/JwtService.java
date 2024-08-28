package com.cursos.api.springsecuritycourse.service.auth;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(UserDetails user) {
        String jwt= Jwts;
        return jwt;
    }
}
