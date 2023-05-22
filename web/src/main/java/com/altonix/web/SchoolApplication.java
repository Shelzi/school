package com.altonix.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static com.altonix.repository.constant.ProfileName.PRODUCTION;
import static com.altonix.repository.constant.ProfileName.DEVELOPMENT;

@SpringBootApplication
@EntityScan("com.altonix.repository.*")
@EnableJpaRepositories("com.altonix.repository.*")
@ComponentScan("com.altonix.*")
public class SchoolApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SchoolApplication.class);
        application.setAdditionalProfiles(PRODUCTION);
        application.run(args);
    }
}
