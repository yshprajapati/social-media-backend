package com.yash.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	public String generateToken(String username) {
		
		return Jwts.builder()
		.subject(username)
		.issuedAt(new Date()) 
		.expiration(new Date(System.currentTimeMillis()+ 1000*60*60))
		.signWith(getSignKey())
		.compact();
		
	}
	
	public SecretKey getSignKey() {
		return Keys.hmacShaKeyFor(secretKey.getBytes());
	}
}
