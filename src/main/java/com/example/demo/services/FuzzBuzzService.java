package com.example.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FuzzBuzzService {

    public String getFuzzBuzz(Integer input){
        log.info(""+input);
        if( checkIsFuzzBuzz(input) ){
            return "FuzzBuzz";
        }else if ( checkIsFuzz(input) ){
            return "Fuzz";
        }else if ( checkIsBuzz(input) ){
            return "Buzz";
        }else {
            return String.valueOf(input);
        }
    }
    private boolean checkIsFuzzBuzz(Integer input){
        return  input%3 == 0 && input%5 == 0;
    }
    private boolean checkIsFuzz(Integer input){
        return  input%3 == 0;
    }
    private boolean checkIsBuzz(Integer input){
        return  input%5 == 0;
    }

}
