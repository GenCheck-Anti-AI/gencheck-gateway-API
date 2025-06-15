package com.gencheck_anti_ai.gencheck_gateway_api.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceUrlsConfig {

    @Value("${services.text-analyzer}")
    private String textAnalyzerUrl;

    @Value("${services.image-analyzer}")
    private String imageAnalyzerUrl;

    @Value("${services.video-analyzer}")
    private String videoAnalyzerUrl;

    public String getTextAnalyzerUrl() {
        return textAnalyzerUrl;
    }

    public String getImageAnalyzerUrl() {
        return imageAnalyzerUrl;
    }

    public String getVideoAnalyzerUrl() {
        return videoAnalyzerUrl;
    }
}

