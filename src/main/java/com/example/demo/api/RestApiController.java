package com.example.demo.api;

import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.FuzzBuzzService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/fuzzbuzz")
public class RestApiController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FuzzBuzzService fuzzBuzzService;

    @GetMapping("/sayHi")
    public List<UserEntity> sayHi(){
        List<UserEntity> UserEntities = userRepository.findAll();
        return UserEntities;
    }

    @GetMapping("/{number}")
    public String sayHi2(@PathVariable String number){
        try{
            int n = Integer.parseInt(number);
            if (checkInputNotLessThanZeroAndNotGreaterThanThousand(n)){
                return "Invalid integer";
            }
            return fuzzBuzzService.getFuzzBuzz(n);
        }catch (Exception ex){
            ex.printStackTrace();
            return "Invalid integer";
        }
    }

    private boolean checkInputNotLessThanZeroAndNotGreaterThanThousand(Integer input){
        return input <= 0 || input >= 10000;
    }
}
