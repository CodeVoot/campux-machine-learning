package com.example.Cardatabase.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.http.HttpHeaders;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtService {
	
	static final long EXPIRATIONTIME = 86400000;
	// 1 day in ms . should be more shorter in production
	
	static final String PREFIX_STRING = "Bearer";
	
	// Generate Secret Key only for demonstration purposes
	// In production, you should read it from the application configurations
	
	static final Key key = Keys.secretKeyFor (SignatureAlgorithm.HS256);
	
	// Generate signed JWT token
	public String getToken(String username) {
			String token = Jwts.builder().setSubject(username)
							.setExpiration(new Date(System.currentTimeMillis() +
									EXPIRATIONTIME)).signWith(key)
							.compact();
			return token;
	}
			
	// Get a token from request Authorization header,
	// verify the token, and get username
	
	public String getAuthUser(HttpServletRequest request) {
	
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if (token != null) {
			String user = Jwts.parserBuilder().setSigningKey(key)
							.build().parseClaimsJws(token.replace(PREFIX_STRING, ""))
							.getBody().getSubject();
		if (user != null)
			return user;
		}
		return null;
	}
	
}
