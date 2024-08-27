package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    private String about;

    @GetMapping("/About")
    public String About() {
        return "About";
    }
    @GetMapping("/mainscreen.html")
    public String mainscreen() {
        return "mainscreen";
    }
}