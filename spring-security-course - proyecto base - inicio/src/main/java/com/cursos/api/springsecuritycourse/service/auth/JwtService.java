package com.cursos.api.springsecuritycourse.service.auth;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    public String generateToken(UserDetails user,  Map<String, Object> extraClaims ) {
        Date issuedAt= new Date(System.currentTimeMillis());
        String jwt= String.valueOf(Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(issuedAt)
        );

        return jwt;
    }
}
