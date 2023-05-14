package com.sprint06.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_movimento_estoque")
public class EstoqueModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@ManyToOne
@JoinColumn(name = "produto_id")
private ProdutoModel produto;
}
