package com.example.auth.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Data
public class AuthenticationResponse {
    private String response;
    public AuthenticationResponse(String response) {
        this.response = response;
    }
}
