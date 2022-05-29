package com.example.vendasapi.rest.produtos;

import com.example.vendasapi.model.Produto;
import com.example.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/home")
    ResponseEntity<String> home() {
        return ResponseEntity.ok("oi");
    }

    @PostMapping("/produtos")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Produto> save(@Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(repository.save(produto));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> update(@PathVariable long id, @Valid @RequestBody Produto produtoAtualizado){
        Optional<Produto> produtoExistente = repository.findById(id);
        if(produtoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        produtoAtualizado.setId(id);
        repository.save(produtoAtualizado);
        return ResponseEntity.ok().build();
    }
}
