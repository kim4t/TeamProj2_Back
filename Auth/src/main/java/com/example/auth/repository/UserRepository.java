package com.example.auth.repository;

import com.example.auth.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel,String> {

    UserModel findByUserName(String userName);
}
