package com.example.timesheet.repository;

import com.example.timesheet.model.TimeSheetModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TimeSheetRepository extends MongoRepository<TimeSheetModel,String> {
    TimeSheetModel findByWeekEnding(String weekEnding);
    List<TimeSheetModel> findByUser(String userName);
}
