package com.example.agendador_email.module;

import com.example.agendador_email.email.EnvioEmail;
import com.example.agendador_email.model.entity.UsuarioEmailEntity;
import com.example.agendador_email.model.service.UsuarioEmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class Agendador {

    final UsuarioEmailService usuarioEmailService;
    public Agendador(UsuarioEmailService usuarioEmailService) {
        this.usuarioEmailService = usuarioEmailService;
    }

//    @Scheduled(cron = "0 45 19 * * *")
    @Scheduled(fixedDelay = 10000)
    public void agendarTarefa(){

        List<UsuarioEmailEntity> usuarioEmailEntityList = usuarioEmailService.findAll();

        usuarioEmailEntityList.forEach(usuarioEmailEntity -> {
            String email = usuarioEmailEntity.getEmailUsuario();
            String nome = usuarioEmailEntity.getNomeUsuario();

            Date dtNascimento = usuarioEmailEntity.getDataAniversario();
            Calendar calendarDtNascimento = Calendar.getInstance();
            calendarDtNascimento.setTime(dtNascimento);

            int diaAniversario = calendarDtNascimento.get(Calendar.DAY_OF_MONTH);
            int mesAniversario = calendarDtNascimento.get(Calendar.MONTH);
            String dataAniversarioParsed = diaAniversario + "/" + mesAniversario;

            Date dtAtual = new Date();
            Calendar calendarDtAtual = Calendar.getInstance();
            calendarDtAtual.setTime(dtAtual);
            int dtAtualDia = calendarDtAtual.get(Calendar.DAY_OF_MONTH);
            int dtAtualMes = calendarDtAtual.get(Calendar.MONTH);
            String dtAtualParsed = dtAtualDia + "/" + dtAtualMes;


            System.out.println(dataAniversarioParsed);
            System.out.println(dtAtualParsed);

            String mensagem;
            String assunto;

            if(dataAniversarioParsed.equals(dtAtualParsed)){
                mensagem = """
                        Hoje é um dia especial, pois celebramos o seu aniversário! 
                                                    
                        Neste momento de alegria e renovação, quero expressar meus mais sinceros votos de felicidade, saúde e prosperidade em sua vida. Que este novo ciclo seja repleto de momentos marcantes, conquistas e realizações.
                            """;
                assunto = "Hoje é o seu aniversário";
            } else {
                mensagem = "Hoje é um dia normal";
                assunto = "Hoje é um dia normal";
            }

            boolean isEnviado = EnvioEmail.enviarEmail(email, assunto, mensagem);

            System.out.println(isEnviado);
        });

    }

}
