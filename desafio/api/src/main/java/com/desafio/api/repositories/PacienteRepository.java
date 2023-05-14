package com.desafio.api.repositories;

import com.desafio.api.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel,Integer> {

}
