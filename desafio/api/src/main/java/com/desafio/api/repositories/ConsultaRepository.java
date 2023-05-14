package com.desafio.api.repositories;

import com.desafio.api.models.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<ConsultaModel,Integer> {
}
