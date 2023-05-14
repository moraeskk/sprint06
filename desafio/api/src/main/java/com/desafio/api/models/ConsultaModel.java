package com.desafio.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "tb_consulta")
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Column(name = "data_e_hora")
    private Date dataHora;

    @ManyToOne
    @JoinColumn(name = "crm_medico")
    private MedicoModel medico;

    @ManyToOne
    @JoinColumn(name = "paciente_consultado")
    private PacienteModel paciente;

    @Column(length = 300)
    private String tipoDeConsulta;

}
