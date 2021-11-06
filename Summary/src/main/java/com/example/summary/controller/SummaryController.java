package com.example.summary.controller;

import com.example.summary.domain.Summary;
import com.example.summary.service.MongoSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SummaryController {
    private final MongoSummaryService service;

    @Autowired
    public SummaryController(MongoSummaryService service){
        this.service = service;
    }

    @GetMapping("/summary")
    public List<Summary> findAll(){
        return service.findAll();
    }
}
