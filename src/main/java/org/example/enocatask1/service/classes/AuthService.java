package org.example.enocatask1.service.classes;

import lombok.RequiredArgsConstructor;
import org.example.enocatask1.dto.JwtResponse;
import org.example.enocatask1.dto.LogInRequest;
import org.example.enocatask1.dto.SignUpRequest;
import org.example.enocatask1.entities.User;
import org.example.enocatask1.repo.UserRepo;
import org.example.enocatask1.service.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    private final UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JWTService jwtService;

    public User signUp(SignUpRequest signUpRequest){
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setSurname(signUpRequest.getSurname());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(signUpRequest.getRole());
        userRepo.save(user);
        return user;
    }

    public JwtResponse logIn(LogInRequest logInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInRequest.getEmail(), logInRequest.getPassword()));
        var user = userRepo.findByEmail(logInRequest.getEmail());
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwt);
        jwtResponse.setRefreshToken(refreshToken);
        return jwtResponse;
    }
}
