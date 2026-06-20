package com.srgec.movies_app.config;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private final String secretkey = "mysecretkeymysecretkeymysecretkeymysecretkey"; //256-bit

    public String generateToken(String email){
        return Jwts.builder()
        .subject(email)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis()+1000*60*60)) /* 1000 milliseconds*60 sec*60min ->1sec*60sec==1min-->1min*60min=1hr */
        .signWith(Keys.hmacShaKeyFor(secretkey.getBytes()))
        .compact();
    }

    public String extractEmail(String token){
        return Jwts.parser()
        .verifyWith(Keys.hmacShaKeyFor(secretkey.getBytes()))
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();

    }

    
       
    }