package com.cb.controller;

import com.cb.model.User;
import com.cb.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "user saved successfully!!";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
