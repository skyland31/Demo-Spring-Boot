package com.example.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FuzzBuzzService {

    public String getFuzzBuzz(int n){
        String result="";
        log.info(""+n);
        if( n%3 == 0 && n%5 == 0){
            result = "FuzzBuzz";
        }else if ( n%3 == 0){
            result = "FuzzBuzz";
        }else if ( n%5 == 0){
            result = "Buzz";
        }else {
            result = String.valueOf(n);
        }
        return result;
    }

}
