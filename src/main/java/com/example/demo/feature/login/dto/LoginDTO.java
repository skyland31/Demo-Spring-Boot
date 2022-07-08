package com.example.demo.feature.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @JsonProperty("login_username")
    private String username;
    @JsonProperty("login_password")
    private String password;
}
