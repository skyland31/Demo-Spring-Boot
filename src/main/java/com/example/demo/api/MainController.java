package com.example.demo.api;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/sayHi")
    public List<UserEntity> sayHi(){
        List<UserEntity> UserEntities = userRepository.findAll();
        return UserEntities;
    }

    @GetMapping("/sayHi2")
    public String sayHi2(){
        return "Hello2";
    }

}
