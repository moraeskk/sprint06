package com.desafio.api.services;

import com.desafio.api.models.PacienteModel;
import com.desafio.api.repositories.PacienteRepository;
import com.desafio.api.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class pacienteServiceTeste {

    @InjectMocks
    private PacienteService service;

    @Mock
    private PacienteRepository repository;

    @Test
    public void testaListagemPorID() {

        //prepara
        List<PacienteModel> listaTest = new ArrayList<>();
        listaTest.add(new PacienteModel());
        when(repository.findAll()).thenReturn(listaTest);
        //executa
        int quantidade = service.listarPacientes().size();

        //valida
        Assertions.assertEquals(1, quantidade);
    }
}
