package com.desafio.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "tb_medico")
public class MedicoModel {

    @Id
    private Integer crm;

    @Column(length = 40)
    private String nome;

    @Column(length = 20)
    private String formacao;


}
