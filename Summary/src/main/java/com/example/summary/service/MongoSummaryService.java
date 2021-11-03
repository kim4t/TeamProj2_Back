package com.example.summary.service;

import com.example.summary.dao.SummaryRepository;
import com.example.summary.domain.Summary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoSummaryService {
    private SummaryRepository repository;

    public MongoSummaryService(SummaryRepository repository){
        this.repository = repository;
    }

    public List<Summary> findAll(){
        return repository.findAll();
    }
}
