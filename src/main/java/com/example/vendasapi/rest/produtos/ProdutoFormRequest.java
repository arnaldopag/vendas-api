package com.example.vendasapi.rest.produtos;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class ProdutoFormRequest {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false, length = 255)
        private String descricao;

        @Column(nullable = false, length = 255)
        private String nome;

        @Column
        private BigDecimal preco;

        @Column(nullable = false, length = 255)
        private String codigo;
}
