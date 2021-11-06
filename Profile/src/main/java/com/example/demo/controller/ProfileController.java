package com.example.demo.controller;

import com.example.demo.domain.Contact;
import com.example.demo.service.MongoProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {
    private final MongoProfileService service;

    @Autowired
    public ProfileController(MongoProfileService service){
        this.service = service;
    }

    @GetMapping(value="/profile/{user}")
    public Contact findContactByUser(@PathVariable String user){
        return service.findContactByUser(user);
    }

    @PostMapping("/profile")
    public void saveContact(@RequestBody Contact contact){
        service.saveContact(contact);
    }
}
