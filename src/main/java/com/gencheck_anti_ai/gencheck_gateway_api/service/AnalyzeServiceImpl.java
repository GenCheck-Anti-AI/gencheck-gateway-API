package com.gencheck_anti_ai.gencheck_gateway_api.service;

import com.gencheck_anti_ai.gencheck_gateway_api.config.ServiceUrlsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class AnalyzeServiceImpl implements AnalyzeService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServiceUrlsConfig urls;

    private ResponseEntity<String> forwardRequest(MultipartFile file, String targetUrl) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            };

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", resource);

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            return restTemplate.exchange(targetUrl, HttpMethod.POST, requestEntity, String.class);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    public ResponseEntity<String> analyzeText(MultipartFile file) {
        return forwardRequest(file, urls.getTextAnalyzerUrl());
    }

    public ResponseEntity<String> analyzeImage(MultipartFile file) {
        return forwardRequest(file, urls.getImageAnalyzerUrl());
    }

    public ResponseEntity<String> analyzeVideo(MultipartFile file) {
        return forwardRequest(file, urls.getVideoAnalyzerUrl());
    }
}

