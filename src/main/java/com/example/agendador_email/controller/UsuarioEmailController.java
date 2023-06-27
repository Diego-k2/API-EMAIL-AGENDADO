package com.example.agendador_email.controller;

import com.example.agendador_email.dto.UsuarioEmailDto;
import com.example.agendador_email.entity.UsuarioEmailEntity;
import com.example.agendador_email.response.ErrorResponse;
import com.example.agendador_email.service.UsuarioEmailService;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController()
@RequestMapping("/usuario")
public class UsuarioEmailController {

    final UsuarioEmailService usuarioEmailService;
    public UsuarioEmailController(UsuarioEmailService usuarioEmailService) {
        this.usuarioEmailService = usuarioEmailService;
    }

    @PostMapping("/novo")
    public ResponseEntity<Object> criarUsuario(@Valid @RequestBody UsuarioEmailDto usuarioEmailDto) {
        try{
            UsuarioEmailEntity usuarioEmailEntity = usuarioEmailDto.parseToUsuarioEntity();
            System.out.println();
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioEmailService.save(usuarioEmailEntity));
        } catch (ParseException parseException){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Formato de Data Inválido");
            Gson gson = new Gson();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(gson.toJson(errorResponse));
        }
    }
}
