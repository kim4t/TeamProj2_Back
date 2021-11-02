package com.example.auth;

import com.example.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class setup implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        checkUserRepo();
    }
    public  void checkUserRepo(){
        System.out.println(userRepository.findAll());
    }
}
