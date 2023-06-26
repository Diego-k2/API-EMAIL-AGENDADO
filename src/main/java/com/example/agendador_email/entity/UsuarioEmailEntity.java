package com.example.agendador_email.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_email_usuario")
public class UsuarioEmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "cl_nome_usuario", nullable = false)
    private  String nomeUsuario;

    @Column(name = "cl_email_usuario", nullable = false)
    private  String emailUsuario;

    @Column(name = "cl_dt_aniversario", nullable = false)
    private Date dataAniversario;

    public UsuarioEmailEntity(String nomeUsuario, String emailUsuario, Date dataAniversario) {
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.dataAniversario = dataAniversario;
    }

    public UsuarioEmailEntity(){}

    public String getId(){
        return id.toString();
    }

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

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
}
