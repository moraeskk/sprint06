package com.desafio.api.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class pacienteTeste {
    @Test
    public void testaFieldNome() {

        PacienteModel paciente = new PacienteModel();

        paciente.setNome("vasco da gama");

        Assertions.assertEquals("vasco da gama",paciente.getNome());
    }
}
