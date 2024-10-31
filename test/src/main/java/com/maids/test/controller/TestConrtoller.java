package com.maids.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConrtoller {

    @Value("${python.api.url}")
    private String pythonApiUrl;

    @GetMapping("/test-url")
    public String getPythonApiUrl() {
        return pythonApiUrl;
    }
    
}
