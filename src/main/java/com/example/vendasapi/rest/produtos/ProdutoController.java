package com.example.vendasapi.rest.produtos;

import com.example.vendasapi.model.Produto;
import com.example.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.CREATED)
    public  ProdutoFormRequest salvar(@Valid @RequestBody ProdutoFormRequest produto){
        return  repository.save(produto);
    }
}
