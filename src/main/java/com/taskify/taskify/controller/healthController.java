package com.taskify.taskify.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class healthController {
    @GetMapping
    public String checkHealth() {
        return "Taskify is up and running!";
    }
}
