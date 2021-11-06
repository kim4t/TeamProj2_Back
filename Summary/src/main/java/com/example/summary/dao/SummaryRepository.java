package com.example.summary.dao;

import com.example.summary.domain.Summary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummaryRepository extends MongoRepository<Summary, String> {
    List<Summary> findSummaryByUser(String username);
}
