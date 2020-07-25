package com.newptit.freelib.controller;

import com.newptit.freelib.model.User;
import com.newptit.freelib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://freelib.vercel.app/", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/user")
    public ResponseEntity editUser(@RequestBody User user) {
        User newUser = userRepository.save(user);
        if (newUser != null) {
            return new ResponseEntity(newUser, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}
