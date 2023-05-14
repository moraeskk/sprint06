package com.desafio.api.service;

import com.desafio.api.models.ConsultaModel;
import com.desafio.api.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public void add(ConsultaModel novaConsulta) {consultaRepository.save(novaConsulta);}

    public List<ConsultaModel> listarConsultas() {return consultaRepository.findAll();}

    public void update(Integer id,ConsultaModel consulta){if (consultaRepository.existsById(id)){consultaRepository.save(consulta);}}

    public void remove(Integer id){if (consultaRepository.existsById(id)){consultaRepository.deleteById(id);}}

    public ConsultaModel pesquisarConsulaPorId(Integer id) {

        Optional<ConsultaModel> optConsultaModel = consultaRepository.findById(id);
        if (optConsultaModel.isEmpty()) {

            return null;
        }
        return optConsultaModel.get();
    }

}
