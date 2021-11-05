package com.example.auth.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Data
public class AuthenticationResponse {
    private String token;
    private String userName;
    private String status;

    public AuthenticationResponse(String token, String userName, String status) {
        this.token = token;
        this.userName = userName;
        this.status = status;
    }

    public AuthenticationResponse(String status) {
        this.status = status;
    }
}
