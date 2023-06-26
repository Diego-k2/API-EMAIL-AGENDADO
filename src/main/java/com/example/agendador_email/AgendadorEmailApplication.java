package com.example.agendador_email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AgendadorEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgendadorEmailApplication.class, args);
    }



}
