package com.example.auth.model;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String userName;
    private String password;
}
