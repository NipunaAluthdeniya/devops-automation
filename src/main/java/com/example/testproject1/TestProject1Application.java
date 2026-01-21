package com.example.testproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestProject1Application {

    @GetMapping
    public String message() {return "Welcome to my world";}

    public static void main(String[] args) {
        SpringApplication.run(TestProject1Application.class, args);
    }

}
