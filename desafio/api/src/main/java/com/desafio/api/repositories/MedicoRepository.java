package com.desafio.api.repositories;

import com.desafio.api.models.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedicoRepository extends JpaRepository<MedicoModel,Integer> {

}
