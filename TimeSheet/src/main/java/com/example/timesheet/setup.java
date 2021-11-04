package com.example.timesheet;

import com.example.timesheet.model.TimeSheetModel;
import com.example.timesheet.repository.TimeSheetRepository;
import com.example.timesheet.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class setup implements CommandLineRunner {
    @Autowired
    private TimeSheetRepository timeSheetRepository;
    @Autowired
    private TimeSheetService timeSheetService;
    @Override
    public void run(String... args) throws Exception {
        checkTimeSheetRepo();
    }
    public  void checkTimeSheetRepo(){
        System.out.println(timeSheetService.getByWeekEnding("31 March 2018","61831fca4ee79a2b054f68ba").get());
    }
}
