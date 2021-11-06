package com.example.summary.controller;

import com.example.summary.domain.Summary;
import com.example.summary.service.MongoSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/summary/{username}")
    public List<Summary> findByUser(@PathVariable String username){
        return service.findSummaryByUser(username);
    }

    @GetMapping("/summary/week/{username}")
    public Summary findByWeekEnding(@PathVariable String username, @RequestParam String weekEnding){
        return service.findByWeekEnding(weekEnding,username);
    }

    @PostMapping("/summary")
    public void saveByWeekEnding(@RequestBody Summary summary){
        Summary newSummary = service.findByWeekEnding(summary.getWeekEnding(),summary.getUser());
        newSummary.setComment(summary.getComment());
        newSummary.setApprovalStatus(summary.getApprovalStatus());
        newSummary.setSubmissionStatus(summary.getSubmissionStatus());
        newSummary.setTotalHours(summary.getTotalHours());
        service.saveByWeekEnding(newSummary);
    }
}
