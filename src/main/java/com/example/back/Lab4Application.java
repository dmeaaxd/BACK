package com.example.back;

import com.example.back.interfaces.UserRepository;
import com.example.back.config.RsaKeyProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class Lab4Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository repository) {
        return (args -> {});
    }
}
