package com.baseline.wais.common.service;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface AuthorizationService {

	public String extractUsername(String token);

	public Date extractExpiration(String token);

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

	public String generateToken(UserDetails userDetails);

	public Boolean validateToken(String token, UserDetails userDetails);
}
