package com.example.demo.controllers;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class FuzzBuzzControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName("Test Case 1: Input 1 then Output 1 ")
    void testCase1() {
        log.info("************** Test Case 1: Input 1 then Output 1 ******************");
        log.debug("step1");
        String output = restTemplate.getForObject("/fuzzbuzz/1", String.class);
        log.debug(" pass step1");
        assertEquals("1", output);
    }

    @Test
    @DisplayName("Test Case 2: Input 2 then Output 2 ")
    void testCase2() {
        String output = restTemplate.getForObject("/fuzzbuzz/2", String.class);
        assertEquals("2", output);
    }

    @Test
    @DisplayName("Test Case 3: Input 3 then Output Fuzz ")
    void testCase3() {
        String output = restTemplate.getForObject("/fuzzbuzz/3", String.class);
        assertEquals("Fuzz", output);
    }

    @Test
    @DisplayName("Test Case 4: Input 4 then Output 4 ")
    void testCase4() {
        String output = restTemplate.getForObject("/fuzzbuzz/4", String.class);
        assertEquals("4", output);
    }

    @Test
    @DisplayName("Test Case 5: Input 5 then Output Buzz ")
    void testCase5() {
        String output = restTemplate.getForObject("/fuzzbuzz/5", String.class);
        assertEquals("Buzz", output);
    }

    @Test
    @DisplayName("Test Case 6: Input 10 then Output Buzz ")
    void testCase6() {
        String output = restTemplate.getForObject("/fuzzbuzz/10", String.class);
        assertEquals("Buzz", output);
    }

    @Test
    @DisplayName("Test Case 7: Input 12 then Output Fuzz ")
    void testCase7() {
        String output = restTemplate.getForObject("/fuzzbuzz/12", String.class);
        assertEquals("Fuzz", output);
    }

    @Test
    @DisplayName("Test Case 8: Input 13 then Output 13 ")
    void testCase8() {
        String output = restTemplate.getForObject("/fuzzbuzz/13", String.class);
        assertEquals("13", output);
    }

    @Test
    @DisplayName("Test Case 9: Input 15 then Output FuzzBuzz ")
    void testCase9() {
        String output = restTemplate.getForObject("/fuzzbuzz/15", String.class);
        assertEquals("FuzzBuzz", output);
    }

    @Test
    @DisplayName("Test Case 10: Input 20 then Output Buzz ")
    void testCase10() {
        String output = restTemplate.getForObject("/fuzzbuzz/20", String.class);
        assertEquals("Buzz", output);
    }

    @Test
    @DisplayName("Test Case 11: Input 45 then Output FuzzBuzz ")
    void testCase11() {
        String output = restTemplate.getForObject("/fuzzbuzz/45", String.class);
        assertEquals("FuzzBuzz", output);
    }

    @Test
    @DisplayName("Test Case 12: Input 150 then Output FuzzBuzz ")
    void testCase12() {
        String output = restTemplate.getForObject("/fuzzbuzz/150", String.class);
        assertEquals("FuzzBuzz", output);
    }

    @Test
    @DisplayName("Test Case 13: Input 8885 then Output Buzz ")
    void testCase13() {
        String output = restTemplate.getForObject("/fuzzbuzz/8885", String.class);
        assertEquals("Buzz", output);
    }

    @Test
    @DisplayName("Test Case 14: Input 9999 then Output Fuzz ")
    void testCase14() {
        String output = restTemplate.getForObject("/fuzzbuzz/9999", String.class);
        assertEquals("Fuzz", output);
    }

    @Test
    @DisplayName("Test Case 15: Input ==0 then Output invalid number ")
    void testCase15() {
        String output = restTemplate.getForObject("/fuzzbuzz/0", String.class);
        assertEquals("invalid number", output);
    }

    @Test
    @DisplayName("Test Case 16: Input = -5 then Output invalid number ")
    void testCase16() {
        String output = restTemplate.getForObject("/fuzzbuzz/-5", String.class);
        assertEquals("invalid number", output);
    }

    @Test
    @DisplayName("Test Case 17: Input = 10000 then Output invalid number ")
    void testCase17() {
        String output = restTemplate.getForObject("/fuzzbuzz/10000", String.class);
        assertEquals("invalid number", output);
    }

    @Test
    @DisplayName("Test Case 18: Input = 10001 then Output invalid number ")
    void testCase18() {
        String output = restTemplate.getForObject("/fuzzbuzz/10001", String.class);
        assertEquals("invalid number", output);
    }

    @Test
    @DisplayName("Test Case 19: Input = A then Output invalid integer ")
    void testCase19() {
        String output = restTemplate.getForObject("/fuzzbuzz/A", String.class);
        assertEquals("invalid integer", output);
    }

    @Test
    @DisplayName("Test Case 20: Input = 2Z then Output invalid integer ")
    void testCase20() {
        String output = restTemplate.getForObject("/fuzzbuzz/2Z", String.class);
        assertEquals("invalid integer", output);
    }

    @Test
    @DisplayName("Test Case 21: Input = 2# then Output invalid integer ")
    @SneakyThrows
    void testCase21() {
        String output = restTemplate.getForObject("/fuzzbuzz/" + URLEncoder.encode("2#", StandardCharsets.UTF_8.toString()), String.class);
        assertEquals("invalid integer", output);
    }

    @Test
    @DisplayName("Test Case 22: Input = 50.5 then Output invalid integer ")
    void testCase22() {
        String output = restTemplate.getForObject("/fuzzbuzz/50.5", String.class);
        assertEquals("invalid integer", output);
    }

    @Test
    @DisplayName("Test Case 23: Input = 2$ then Output invalid integer ")
    void testCase23() {
        String output = restTemplate.getForObject("/fuzzbuzz/2$", String.class);
        assertEquals("invalid integer", output);
    }
}
