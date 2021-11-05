package com.example.profile.controller;

import com.example.profile.domain.Contact;
import com.example.profile.service.MongoProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProfileController {
    private final MongoProfileService service;

    @Autowired
    public ProfileController(MongoProfileService service){
        this.service = service;
    }

    @GetMapping(value="/profile", params = "user")
    public Contact findContactByUser(@RequestParam String user){
        return service.findContactByUser(user);
    }

    @PostMapping("/profile")
    public void saveContact(@RequestBody Contact contact){
        service.saveContact(contact);
    }
//    public List<Contact> findAll(){
//        return service.findAll();
//    }
}
