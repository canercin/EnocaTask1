package org.example.enocatask1.service.classes;

import org.example.enocatask1.entities.User;
import org.example.enocatask1.repo.UserRepo;
import org.example.enocatask1.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void save(User user){
        userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id){
        return userRepo.findById(id).get();
    }

    public void update(User user){
        userRepo.save(user);
    }

    public void delete(Long id){
        userRepo.deleteById(id);
    }

    public User loadUserByUsername(String username){
        return userRepo.findByEmail(username);
    }

    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepo.findByEmail(username);
            }
        };
    }
}
