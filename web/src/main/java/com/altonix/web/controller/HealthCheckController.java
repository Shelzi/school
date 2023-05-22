package com.altonix.web.controller;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    private static final String HEALTH_CHECK_STATUS = "status:";
    private static final String HEALTH_CHECK_MESSAGE = "UP";
    
    @RequestMapping("/health")
    public Pair<String, String> checkHealth() {
        return Pair.of(HEALTH_CHECK_STATUS, HEALTH_CHECK_MESSAGE);
    }
}
