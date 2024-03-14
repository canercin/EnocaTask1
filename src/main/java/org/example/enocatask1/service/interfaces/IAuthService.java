package org.example.enocatask1.service.interfaces;

import org.example.enocatask1.dto.JwtResponse;
import org.example.enocatask1.dto.LogInRequest;
import org.example.enocatask1.dto.SignUpRequest;
import org.example.enocatask1.entities.User;

public interface IAuthService {
    User signUp(SignUpRequest signUpRequest);

    JwtResponse logIn(LogInRequest logInRequest);
}
