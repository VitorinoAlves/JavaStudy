package br.com.calves.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.calves.domain.Cliente;

public interface IClienteRepository extends MongoRepository<Cliente, String>{
	
	Optional<Cliente> findByCpf(Long cpf);

}
