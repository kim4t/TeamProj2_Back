package com.example.demo.dao;

import com.example.demo.domain.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends MongoRepository<Contact, String> {
    List<Contact> findContactByUser(String user);
}
