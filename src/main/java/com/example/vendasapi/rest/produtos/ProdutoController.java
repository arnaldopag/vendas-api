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
    @GetMapping
    public List<Produto> findAll() {return repository.findAll();}

    @GetMapping("{id}")
    public ResponseEntity<Optional<Produto>> getById (@PathVariable Long id){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable long id){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        repository.delete(produto.get());
        return ResponseEntity.noContent().build();
    }

}
