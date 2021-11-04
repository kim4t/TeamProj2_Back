package com.example.timesheet.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.function.Supplier;

@Data
@Document(collection = "timeSheet")
public class TimeSheetModel implements Supplier<TimeSheetModel> {
    @Id
    private String id;
    String filePath;
    String weekEnding;
    List<Object> timeSheet;
    String user;

    @Override
    public TimeSheetModel get() {
        return null;
    }
}
