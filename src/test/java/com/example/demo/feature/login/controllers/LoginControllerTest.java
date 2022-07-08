package com.example.demo.feature.login.controllers;

import com.example.demo.feature.login.dto.LoginDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Test Case 1: Login fail with username: testfail and password: 1234@abcd then return false")
    void testCase1() {
        HttpEntity<LoginDTO> request = new HttpEntity<>(new LoginDTO("testfail", "1234@abcd"));
        ResponseEntity<Boolean> response = testRestTemplate.exchange("/login", HttpMethod.POST, request, Boolean.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Boolean.FALSE, response.getBody());
    }

    @Test
    @DisplayName("Test Case 2: Login fail with username: testpass and password: 1234@abcd then return true")
    void testCase2() {
        HttpEntity<LoginDTO> request = new HttpEntity<>(new LoginDTO("testpass", "1234@abcd"));
        ResponseEntity<Boolean> response = testRestTemplate.exchange("/login", HttpMethod.POST, request, Boolean.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Boolean.TRUE, response.getBody());
    }
}