package com.example.demo.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName("Test Case 1: Test hello API")
    void testCase01(){
        String response = restTemplate.getForObject("/home/hello", String.class);
        assertEquals("hello my DXC-Demo",response);
    }

}