package com.example.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Set;

@Data
@Document(collection = "user")
public class UserModel {
    @Id
    private String id;
    private String userName;
    private String password;

}
