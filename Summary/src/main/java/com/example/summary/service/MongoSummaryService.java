package com.example.summary.service;

import com.example.summary.dao.SummaryRepository;
import com.example.summary.domain.Summary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MongoSummaryService {
    private SummaryRepository repository;

    public MongoSummaryService(SummaryRepository repository){
        this.repository = repository;
    }

    public List<Summary> findAll(){
        return repository.findAll();
    }

    public List<Summary> findSummaryByUser(String username){
        return repository.findSummaryByUser(username);
    }

    public Summary findByWeekEnding(String weekEnding, String username){
        List<Summary> summary = repository.findSummaryByUser(username)
                .stream()
                .filter(summ -> summ.getWeekEnding().equals(weekEnding))
                .collect(Collectors.toList());
        return summary.get(0);
    }

    public void saveByWeekEnding(Summary summary){
        repository.save(summary);
    }
}
