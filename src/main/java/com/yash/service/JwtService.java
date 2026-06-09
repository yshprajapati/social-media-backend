package com.yash.service;


import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.token.Token;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
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
	
	private SecretKey getSignKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}
	

	private Claims extractClaims(Token token) {
		return Jwts.parser()
				.verifyWith(getSignKey())
				.build()
				.parseSignedClaims(secretKey)
				.getPayload();
	}
	
	public String extractUserName(Token token) {
		return extractClaims(token).getSubject();
	}
}
