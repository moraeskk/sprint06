package com.desafio.api.repositories;

import com.desafio.api.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRespository extends JpaRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByNomeDeUsuario(String nomeDeUsuario);
}
