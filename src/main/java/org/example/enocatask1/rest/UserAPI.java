package org.example.enocatask1.rest;

import org.example.enocatask1.entities.User;
import org.example.enocatask1.service.classes.UserService;
import org.example.enocatask1.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAPI {
    private IUserService userService;

    @Autowired
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(user.toString() + " eklendi", HttpStatus.OK);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody User user){
        userService.update(user);
        return new ResponseEntity<>(user.toString() + " güncellendi", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(id + "'li kullanıcı silindi", HttpStatus.OK);
    }
}
