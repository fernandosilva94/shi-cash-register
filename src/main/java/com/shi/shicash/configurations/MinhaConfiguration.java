package com.shi.shicash.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinhaConfiguration {
    @Bean(name = "applicationName")
    public String applicationName() {
        return "ShiCashi App!";
    }
}
