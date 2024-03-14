package org.example.enocatask1.rest;

import lombok.RequiredArgsConstructor;
import org.example.enocatask1.dto.LogInRequest;
import org.example.enocatask1.dto.SignUpRequest;
import org.example.enocatask1.entities.User;
import org.example.enocatask1.service.interfaces.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthAPI {
    private final IAuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody LogInRequest logInRequest){
        return ResponseEntity.ok(authService.logIn(logInRequest));
    }
}
