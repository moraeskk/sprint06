package com.desafio.api.service;

import com.desafio.api.models.PacienteModel;
import com.desafio.api.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public void add(PacienteModel novoPaciente) {
        pacienteRepository.save(novoPaciente);
    }

    public List<PacienteModel> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public void update(Integer id, PacienteModel paciente) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.save(paciente);
        }
    }

    public void remove(Integer cpf) {
            pacienteRepository.deleteById(cpf);
    }

    public PacienteModel listarPorid(Integer id) {

        Optional<PacienteModel> optPaciente = pacienteRepository.findById(id);
        if (optPaciente.isEmpty()) {

            return null;
        }
        return optPaciente.get();
    }

}
