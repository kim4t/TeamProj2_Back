package com.example.timesheet.service;

import com.example.timesheet.model.TimeSheetModel;
import com.example.timesheet.repository.TimeSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeSheetService {
    @Autowired
    private TimeSheetRepository timeSheetRepository;

    public List<TimeSheetModel> getAllTimeSheet(){
        return timeSheetRepository.findAll();
    }
    public List<TimeSheetModel> getByUser(String userName){
        return timeSheetRepository.findByUser(userName);
    }
    public Optional<TimeSheetModel> getByWeekEnding(String weekEnding, String userName){
        return timeSheetRepository.findByUser(userName).stream().filter(we->we.getWeekEnding().equals(weekEnding)).findAny();
    }
    public TimeSheetModel updateTimeSheet(TimeSheetModel timeSheetModel){
        return timeSheetRepository.save(timeSheetModel);
    }
}
