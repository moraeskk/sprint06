package com.desafio.api.service;

import com.desafio.api.models.MedicoModel;
import com.desafio.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public void add(MedicoModel novoMedico) {
        medicoRepository.save(novoMedico);
    }

    public List<MedicoModel> listarMedicos() {
        return medicoRepository.findAll();
    }

    public void update(Integer crm, MedicoModel medico) {
        if (medicoRepository.existsById(crm)) {
            medicoRepository.save(medico);
        }
    }

    public void remove(Integer crm) {
        if (medicoRepository.existsById(crm)) {
            medicoRepository.deleteById(crm);
        }
    }

    public MedicoModel pesquisarMedicoPorCrm(Integer crm) {

        Optional<MedicoModel> optionalMedicoModel = medicoRepository.findById(crm);
        if (optionalMedicoModel.isEmpty()) {
            return null;
        }
        return optionalMedicoModel.get();
    }
}
