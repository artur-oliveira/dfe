package com.softart.dferestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
})
public class DfeRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfeRestApiApplication.class, args);
    }

}
