package com.example.vendasapi.model.repository;

import com.example.vendasapi.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    @Query(" SELECT c FROM Cliente c where upper(c.nome) like upper(:nome) and c.cpf like :cpf")
    Page<Cliente> findoByCpfOrName(@Param("nome") String nome,
                                   @Param("cpf") String cpf, Pageable pageable);
}
