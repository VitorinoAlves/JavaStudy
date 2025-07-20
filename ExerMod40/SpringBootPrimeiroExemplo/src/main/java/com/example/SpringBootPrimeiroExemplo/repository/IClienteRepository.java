package com.example.SpringBootPrimeiroExemplo.repository;

import com.example.SpringBootPrimeiroExemplo.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {
}
