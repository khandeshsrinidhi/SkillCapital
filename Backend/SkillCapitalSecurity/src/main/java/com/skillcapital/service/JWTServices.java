package com.skillcapital.service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

@SuppressWarnings("deprecation")
@Service
public class JWTServices {

	private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	public String generateToken(String subject) 
	{
		return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(key)
                .compact();
	}

}
