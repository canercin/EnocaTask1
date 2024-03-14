package org.example.enocatask1.dto;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String refreshToken;
}
