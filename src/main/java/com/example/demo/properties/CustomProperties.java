package com.example.demo.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "demo.config")
@RequiredArgsConstructor
@Getter
public class CustomProperties {
    private final String applicationName;
}
