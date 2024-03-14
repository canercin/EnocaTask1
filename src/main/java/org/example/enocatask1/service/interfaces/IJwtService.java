package org.example.enocatask1.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface IJwtService {
    String generateToken(UserDetails userDetails);
    String generateRefreshToken(Map<String, Object> claims, UserDetails userDetails);
    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);

}
