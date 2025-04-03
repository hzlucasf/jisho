package com.hzlucasf.jisho.configuration.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer getWebMvcConfigurer() {
        return new WebMvcConfigurer() {
        };
    }
}
