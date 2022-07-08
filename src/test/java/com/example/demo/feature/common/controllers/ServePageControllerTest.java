package com.example.demo.feature.common.controllers;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServePageControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Test Case 1: Test Load HTML of home screen success")
    void testCase1() {
        ResponseEntity<String> response = testRestTemplate.exchange("/pages/home", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(),"</html>"));
    }
    @Test
    @DisplayName("Test Case 2: Test Load JS of home screen success")
    void testCase2() {
        ResponseEntity<String> response = testRestTemplate.exchange("/pages/js/home", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(),"//]]>"));
    }

    @Test
    @DisplayName("Test Case 3: Test Load HTML of login screen success")
    void testCase3() {
        ResponseEntity<String> response = testRestTemplate.exchange("/pages/login", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(),"</html>"));
    }
    @Test
    @DisplayName("Test Case 4: Test Load JS of login screen success")
    void testCase4() {
        ResponseEntity<String> response = testRestTemplate.exchange("/pages/js/login", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(),"//]]>"));
    }

    @Test
    @DisplayName("Test Case 5: Test Load HTML of gimmaster screen success")
    void testCase5() {
        ResponseEntity<String> response = testRestTemplate.exchange("/pages/master/gim", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(),"</html>"));
    }
    @Test
    @DisplayName("Test Case 6: Test Load JS of gimmaster screen success")
    void testCase6() {
        ResponseEntity<String> response = testRestTemplate.exchange("/pages/js/master/gim", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(),"//]]>"));
    }
}
