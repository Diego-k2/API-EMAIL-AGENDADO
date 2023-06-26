package com.example.agendador_email.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/usuario")
public class UsuarioEmailController {


    @PostMapping("/novo")
    public ResponseEntity<Object> criarUsuario(){

        


        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

}
