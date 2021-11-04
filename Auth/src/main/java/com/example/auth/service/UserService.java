package com.example.auth.service;

import com.example.auth.model.UserModel;
import com.example.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserModel foundUser = userRepository.findByUserName(userName);
        if(foundUser == null)
            return null;
        String name = foundUser.getUserName();
        String password = foundUser.getPassword();
        return new User(name,password,new ArrayList<>());
    }
}
