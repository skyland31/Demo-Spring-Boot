package com.example.demo.controllers;

import com.example.demo.properties.CustomProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final CustomProperties customProperties;

    @GetMapping("/helloHome")
    public String helloApi() {
        return "hello my " + customProperties.getApplicationName();
    }
}
