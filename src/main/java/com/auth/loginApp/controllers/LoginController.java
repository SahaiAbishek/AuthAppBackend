package com.auth.loginApp.controllers;

import com.auth.loginApp.models.User;
import com.auth.loginApp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping("users/signin")
    public ResponseEntity<String> signin(@RequestBody User user) {
        if (user != null && user.getEmail() != null && user.getPassword() != null) {
            Optional<List<User>> optionalUser = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if(optionalUser.isEmpty() || optionalUser.get().isEmpty()){
                return new ResponseEntity<>("Please enter valid user id and password", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("userid or password is missing", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("users/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        if (user != null && user.getEmail() != null && user.getPassword() != null) {
            userRepo.save(user);
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("userid or password is missing", HttpStatus.BAD_REQUEST);
    }
}
