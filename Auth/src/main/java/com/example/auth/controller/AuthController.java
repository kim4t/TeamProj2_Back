package com.example.auth.controller;

import com.example.auth.model.AuthenticationRequest;
import com.example.auth.model.AuthenticationResponse;
import com.example.auth.model.UserModel;
import com.example.auth.repository.UserRepository;
import com.example.auth.service.UserService;
import com.example.auth.utill.JwtUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
//@Setter(onMethod = @__({@Autowired}))
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
//@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/dashboard")
    private String test(){
        return "Welcome "+ SecurityContextHolder.getContext().getAuthentication().getName();
    }
    @PostMapping("/subs")
    private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest request){
        String userName = request.getUserName();
        String password = request.getUserName();
        UserModel userModel = new UserModel();
        userModel.setUserName(userName);
        userModel.setPassword(password);
        try{
            userRepository.save(userModel);
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationResponse("Fail subscription "+userName));
        }
        return ResponseEntity.ok(new AuthenticationResponse("Successful subscription "+userName));
        //return ResponseEntity.ok(userName+" "+password);
    }
    @PostMapping("/auth")
    private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest request){
        String userName = request.getUserName();
        String password = request.getPassword();
        System.out.println(userName + " " + password);
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationResponse("Fail"));
        }
        UserDetails loadedUser =  userService.loadUserByUsername(userName);
        String generatedToken = jwtUtil.generateToken(loadedUser);
        return ResponseEntity.ok(new AuthenticationResponse(generatedToken,userName,"Success"));
    }

}
