package com.example.summary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "summary")
public class Summary {
    @Id
    private String id;

    private String user;
    private String weekEnding;
    private String totalHours;
    private String submissionStatus;
    private String approvalStatus;
    private String comment;
}
