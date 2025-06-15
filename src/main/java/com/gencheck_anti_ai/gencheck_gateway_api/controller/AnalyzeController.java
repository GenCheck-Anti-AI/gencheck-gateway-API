package com.gencheck_anti_ai.gencheck_gateway_api.controller;

import com.gencheck_anti_ai.gencheck_gateway_api.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/analyze")
public class AnalyzeController {

    @Autowired
    private AnalyzeService analyzeService;

    @PostMapping("/text")
    public ResponseEntity<String> analyzeText(@RequestParam("file") MultipartFile file) {
        return analyzeService.analyzeText(file);
    }

    @PostMapping("/image")
    public ResponseEntity<String> analyzeImage(@RequestParam("file") MultipartFile file) {
        return analyzeService.analyzeImage(file);
    }

    @PostMapping("/video")
    public ResponseEntity<String> analyzeVideo(@RequestParam("file") MultipartFile file) {
        return analyzeService.analyzeVideo(file);
    }
}
