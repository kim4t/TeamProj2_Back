package com.example.auth.controller;

import com.example.auth.model.UserModel;
import com.example.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<UserModel> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserModel user){
      UserModel u =  userRepository.insert(user);
      return "user "+ u.getUserName()+" was created";
    }
}
