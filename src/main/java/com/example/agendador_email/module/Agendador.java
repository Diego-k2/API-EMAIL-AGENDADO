package com.example.agendador_email.module;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Agendador {

    @Scheduled(cron = "0 42 19 * * *")
    public void agendarTarefa(){




    }

}
