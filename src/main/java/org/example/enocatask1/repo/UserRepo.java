package org.example.enocatask1.repo;

import org.example.enocatask1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String username);

    User findByRole(String role);
}
