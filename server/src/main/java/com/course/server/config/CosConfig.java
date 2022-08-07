package com.course.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CosConfig implements WebMvcConfigurer {
     @Override
    public void addCorsMappings(CorsRegistry registry){
         registry.addMapping("/**")
                 .allowedOriginPatterns("*")
                 .allowedHeaders(CorsConfiguration.ALL)
                 .allowedMethods(CorsConfiguration.ALL)
                 .allowCredentials(true)
                 .maxAge(3600);
     }
}
