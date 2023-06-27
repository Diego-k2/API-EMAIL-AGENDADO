package com.example.agendador_email.module;

import com.example.agendador_email.entity.UsuarioEmailEntity;
import com.example.agendador_email.service.UsuarioEmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Agendador {

    final UsuarioEmailService usuarioEmailService;
    public Agendador(UsuarioEmailService usuarioEmailService) {
        this.usuarioEmailService = usuarioEmailService;
    }

    @Scheduled(cron = "0 46 19 * * *")
    public void agendarTarefa(){

        List<UsuarioEmailEntity> usuarioEmailEntityList = usuarioEmailService.findAll();

        usuarioEmailEntityList.forEach(usuarioEmailEntity -> {
            String email = usuarioEmailEntity.getEmailUsuario();
            String nome = usuarioEmailEntity.getNomeUsuario();
            Date dtNascimento = usuarioEmailEntity.getDataAniversario();
            Date dtAtual = new Date();

            String mensagem;

            if(dtAtual.compareTo(dtNascimento) == 1){

            } else {

            }
        });

    }

}
