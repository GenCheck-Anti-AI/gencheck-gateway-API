package com.gencheck_anti_ai.gencheck_gateway_api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AnalyzeService {
    ResponseEntity<String> analyzeText(MultipartFile file);

    ResponseEntity<String> analyzeImage(MultipartFile file);

    ResponseEntity<String> analyzeVideo(MultipartFile file);
}
