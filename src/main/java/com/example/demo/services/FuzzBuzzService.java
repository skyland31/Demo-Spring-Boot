package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class FuzzBuzzService {
    public String calculateFuzzBuzz(Integer input) {
        if (checkIsFuzzBuzz(input)) {
            return "FuzzBuzz";
        } else if (checkIsFuzz(input)) {
            return "Fuzz";
        } else if (checkIsBuzz(input)) {
            return "Buzz";
        }
        return input.toString();
    }

    private boolean checkIsFuzzBuzz(Integer input) {
        return input % 3 == 0 && input % 5 == 0;
    }

    private boolean checkIsFuzz(Integer input) {
        return input % 3 == 0;
    }

    private boolean checkIsBuzz(Integer input) {
        return input % 5 == 0;
    }
}
