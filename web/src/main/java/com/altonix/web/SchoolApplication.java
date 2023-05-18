package com.altonix.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SchoolApplication.class);
        // TODO: 5/17/2023 Add profile
        //application.setAdditionalProfiles(ProfileName.DEVELOPMENT);
        application.run(args);
    }
}
