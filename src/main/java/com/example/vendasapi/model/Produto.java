package com.example.vendasapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(nullable = false,length = 255)
    private String descricao;

    @Column(nullable = false,length = 255)
    private String codigo;

    @Column(precision = 16, scale = 2)
    private BigDecimal preco;

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", codigo='" + codigo + '\'' +
                ", preco=" + preco +
                '}';
    }
}
