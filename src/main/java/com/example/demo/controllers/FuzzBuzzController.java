package com.example.demo.controllers;

import com.example.demo.services.FuzzBuzzService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuzzbuzz")
@RequiredArgsConstructor
@Slf4j
public class FuzzBuzzController {
    private final FuzzBuzzService fuzzBuzzService;

    @GetMapping("/{input}")
    public String getFuzzBuzz(@PathVariable("input") String input) {
        try {
            Integer inputInt = new Integer(input);
            if (checkInputNotLessThanZeroAndNotGreaterThanThousand(inputInt)) {
                return "invalid number";
            }
            return fuzzBuzzService.calculateFuzzBuzz(inputInt);
        } catch (NumberFormatException e) {
            return "invalid integer";
        }
    }

    private boolean checkInputNotLessThanZeroAndNotGreaterThanThousand(Integer input) {
        return input <= 0 || input >= 10000;
    }
}
