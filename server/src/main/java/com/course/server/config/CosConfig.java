package com.course.server.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
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
       WebMvcConfigurer.super.addCorsMappings(registry);
     }
}

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CosConfig {
    */
/**
     * 该访问配置跨域访问执行
     *//*

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        //cors跨域配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(Boolean.TRUE);//是否允许携带cookie
        corsConfiguration.addAllowedOriginPattern("*"); //允许跨域访问的域名，可填写具体域名，*代表允许所有访问
        corsConfiguration.addAllowedMethod("*");//允许访问类型：get  post 等，*代表所有类型
        corsConfiguration.addAllowedHeader("*");

        corsConfiguration.setMaxAge(3600L);
        //配置源对象
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        //cors 过滤器对象  注意！CorsWebFilter不要导错包
        return new CorsWebFilter(urlBasedCorsConfigurationSource);
    }
}*/
