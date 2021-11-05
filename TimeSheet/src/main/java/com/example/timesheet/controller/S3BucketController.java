package com.example.timesheet.controller;


import com.example.timesheet.service.AmazonS3BucketService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class S3BucketController {
    private AmazonS3BucketService amazonS3BucketService;

    S3BucketController(AmazonS3BucketService amazonS3BucketService) {
        this.amazonS3BucketService = amazonS3BucketService;
    }

    @PostMapping("/uploadFile/{userName}")
    public String uploadFile(@PathVariable String userName, @RequestPart(value = "file") MultipartFile file) {

        return this.amazonS3BucketService.uploadFile(file, userName);
    }

}
