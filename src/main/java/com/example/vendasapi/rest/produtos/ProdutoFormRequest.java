package com.example.vendasapi.rest.produtos;

import com.example.vendasapi.model.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
public class ProdutoFormRequest {

        private Long id;
        private String descricao;
        private String nome;
        private BigDecimal preco;
        private String codigo;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataCadastro;
        public Produto toModel(){
                return new Produto(id, nome, descricao, codigo, preco,dataCadastro);
        }
        public static ProdutoFormRequest fromModel(Produto produto){
                return new ProdutoFormRequest(
                        produto.getId(),
                        produto.getDescricao(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getCodigo(),
                        produto.getDataCadatro()
                );
        }
}
