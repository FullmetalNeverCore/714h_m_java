package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;



@Configuration
public class config {


    private static final Logger LOGGER = LoggerFactory.getLogger(config.class);

    @Bean
    @Scope(value = "prototype")
    public Person person() {
        return new Person("John");
    }

    @Bean
    public VerifData verdata() {
        return new VerifData("0","0","X");
    }

    @Bean
    public Chatbuffer chatb() {
        return new Chatbuffer("0");
    }

    @Bean
    public NNvals nnvals() {
        return new NNvals("1.1","150","1.85","1.8");
    }

}