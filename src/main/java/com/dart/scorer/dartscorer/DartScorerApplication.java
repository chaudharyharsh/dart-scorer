package com.dart.scorer.dartscorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class DartScorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DartScorerApplication.class, args);
    }

}
