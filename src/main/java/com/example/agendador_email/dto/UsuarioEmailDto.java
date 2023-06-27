package com.example.agendador_email.dto;

import com.example.agendador_email.entity.UsuarioEmailEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioEmailDto {

    @NotNull
    private  String nomeUsuario;

    @NotNull
    private  String emailUsuario;

    @NotNull
    private String dataAniversario;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public UsuarioEmailEntity parseToUsuarioEntity() throws ParseException {

        UsuarioEmailEntity usuarioEmailEntity = new UsuarioEmailEntity();

        usuarioEmailEntity.setEmailUsuario(this.emailUsuario);
        usuarioEmailEntity.setNomeUsuario(this.nomeUsuario);
        usuarioEmailEntity.setDataAniversario(new SimpleDateFormat("dd/MM/yyyy").parse(this.dataAniversario));

        return usuarioEmailEntity;
    }

}
