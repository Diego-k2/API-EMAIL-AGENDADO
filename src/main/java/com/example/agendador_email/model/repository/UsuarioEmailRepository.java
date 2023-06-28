package com.example.agendador_email.model.repository;

import com.example.agendador_email.model.entity.UsuarioEmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioEmailRepository extends JpaRepository<UsuarioEmailEntity, UUID> {


}
