package com.example.PAF_TechAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.example.PAF_TechAssignment"})
@SpringBootApplication
public class PafTechAssignmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PafTechAssignmentApplication.class, args);
    }
}




