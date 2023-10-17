package com.example.vendasapi.rest.produtos;

import com.example.vendasapi.model.Produto;
import com.example.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Produto> save(@Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(repository.save(produto));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Valid @RequestBody Produto produtoAtualizado){
        Optional<Produto> produtoExistente = repository.findById(id);
        if(produtoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        produtoAtualizado.setId(id);
        repository.save(produtoAtualizado);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<Produto> findAll() {return repository.findAll();}

    @GetMapping("{id}")
    public ResponseEntity<Produto> getById (@PathVariable Long id){
        return repository
                .findById(id)
                .map( produto -> ResponseEntity.ok(produto))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar (@PathVariable long id){
        return repository.findById(id)
                .map( produto -> {
                    repository.delete(produto);
                   return ResponseEntity.noContent().build();
                }).orElseGet(()-> ResponseEntity.notFound().build());
    }
}
