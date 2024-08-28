package com.cursos.api.springsecuritycourse.service.auth;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${security.jwt.expiration-in-minutes}")
    private Long EXPIRATION_IN_MINUTES;

    public String generateToken(UserDetails user,  Map<String, Object> extraClaims ) {
        Date issuedAt= new Date(System.currentTimeMillis());
        Date expiration= new Date( (EXPIRATION_IN_MINUTES * 60 * 1000) + issuedAt.getTime());
        String jwt= String.valueOf(Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .signWith(generateKey(), SignatureAlgorithm.ES256)
                .compact()
        );

        return jwt;
    }
}
