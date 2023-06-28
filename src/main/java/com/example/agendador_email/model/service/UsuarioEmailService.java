package com.example.agendador_email.model.service;

import com.example.agendador_email.model.entity.UsuarioEmailEntity;
import com.example.agendador_email.model.repository.UsuarioEmailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioEmailService {

    final UsuarioEmailRepository usuarioEmailRepository;
    public UsuarioEmailService(UsuarioEmailRepository usuarioEmailRepository) {
        this.usuarioEmailRepository = usuarioEmailRepository;
    }

    @Transactional
    public UsuarioEmailEntity save(UsuarioEmailEntity usuarioEmailEntity){
        return usuarioEmailRepository.save(usuarioEmailEntity);
    }

    @Transactional
    public List<UsuarioEmailEntity> findAll(){
        return usuarioEmailRepository.findAll();
    }

}
