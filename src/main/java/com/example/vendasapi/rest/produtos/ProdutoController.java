package com.example.vendasapi.rest.produtos;

import com.example.vendasapi.model.Produto;
import com.example.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;
    @PostMapping
    public  ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto){
        Produto entidadeProduto = new Produto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getCodigo(),
                produto.getPreco());

        repository.save(entidadeProduto);

        System.out.println(entidadeProduto);
        return produto;
    }
}
