package com.example.profile.service;

import com.example.profile.dao.ProfileRepository;
import com.example.profile.domain.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoProfileService {
    private ProfileRepository repository;

    public MongoProfileService(ProfileRepository repository){
        this.repository = repository;
    }

    public List<Contact> findAll(){
        return repository.findAll();
    }

    public Contact findContactByUser(String user) {
        return repository.findContactByUser(user).get(0);
    }

    public void saveContact(Contact contact){ repository.save(contact);}
}
