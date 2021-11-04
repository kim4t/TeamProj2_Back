package com.example.timesheet.controller;

import com.example.timesheet.model.TimeSheetModel;
import com.example.timesheet.model.TimeSheetModelRequest;
import com.example.timesheet.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timeSheet")
public class TimeSheetController {
    @Autowired
    private TimeSheetService timeSheetService;
    @GetMapping()
    public TimeSheetModel getTimeSheet(@RequestBody TimeSheetModelRequest timeSheetModelRequest){
        String weekEnding = timeSheetModelRequest.getWeekEnding();
        String userName = timeSheetModelRequest.getUserName();
        return timeSheetService.getByWeekEnding(weekEnding,userName).orElseGet(new TimeSheetModel());
    }
    @PostMapping()
    public TimeSheetModel updateTimeSheet(@RequestBody TimeSheetModel timeSheetModel){

        return timeSheetService.updateTimeSheet(timeSheetModel);
    }
}
