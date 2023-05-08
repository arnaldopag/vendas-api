package com.example.vendasapi.rest.clientes;

import com.example.vendasapi.model.Cliente;
import com.example.vendasapi.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente){
        return ResponseEntity.ok(repository.save(cliente));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update (@PathVariable long id, @Valid @RequestBody Cliente cliente){
        Optional<Cliente> clienteEncontrado = repository.findById(id);
        if(clienteEncontrado.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        repository.save(cliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Cliente> getById(@PathVariable long id){
        return repository.findById(id)
                         .map(cliente -> ResponseEntity.ok(cliente))
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        return repository
                .findById(id)
                .map(cliete ->{
            repository.delete(cliete);
            return ResponseEntity.noContent().build();
        }).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @GetMapping
    public Page<Cliente> getLista(
            @RequestParam (value = "nome", required = false, defaultValue ="") String nome,

            @RequestParam (value = "cpf", required = false, defaultValue = "") String cpf,
              Pageable pagable
    ){return repository.findoByCpfOrName("%" + nome + "%","%" + cpf + "%",pagable);}

}
