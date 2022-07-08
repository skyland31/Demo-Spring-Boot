package com.example.demo.feature.master.gim.controllers;

import com.example.demo.feature.master.gim.dto.GimHeaderSearchResultDTO;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor
class GimControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Test Case 1: Retrieve All Gim Header Data")
    void testcase1() {
        ResponseEntity<List<GimHeaderSearchResultDTO>> response = testRestTemplate.exchange("/master/gim/header/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<GimHeaderSearchResultDTO>>() {
        });
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<GimHeaderSearchResultDTO> responseList = response.getBody();
        assertNotNull(responseList);
        assertEquals(163, responseList.size());
        assertEquals("WARRANTY_CLAIM_PERIOD", responseList.get(162).getGimType());
    }
}