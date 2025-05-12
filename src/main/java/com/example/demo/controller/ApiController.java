package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {


    @GetMapping("/api")
    public String sendApi() {
        return "sent!";
    }
}
