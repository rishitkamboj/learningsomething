package com.rishit.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class HealthCheck {

@GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }


}
