package org.example.enocatask1.service.interfaces;

import org.example.enocatask1.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService {
    void save(User user);
    List<User> findAll();
    User findById(Long id);
    void update(User user);
    void delete(Long id);
    User loadUserByUsername(String username);
    UserDetailsService userDetailsService();
}
