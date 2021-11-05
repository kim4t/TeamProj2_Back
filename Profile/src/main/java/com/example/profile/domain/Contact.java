package com.example.profile.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "contact")
public class Contact {
    @Id
    private String id;

    private String user;

    private String phone;
    private String email;
    private String address;
    private List<EmergencyContact> emergencyContacts;
}
