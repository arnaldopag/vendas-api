package com.example.vendasapi.rest.produtos;

import com.example.vendasapi.model.Produto;
import com.example.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/home")
    ResponseEntity<String> home(){
        return ResponseEntity.ok("oi");
    }

    @PostMapping("/produtos")
    public  ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto){
        Produto entidadeProduto = new Produto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getCodigo(),
                produto.getPreco()
        );

        repository.save(entidadeProduto);
        System.out.println(entidadeProduto);
        return produto;
    }
}
