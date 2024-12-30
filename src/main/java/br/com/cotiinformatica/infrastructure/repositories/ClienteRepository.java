package br.com.cotiinformatica.infrastructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.domain.models.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, UUID>{
	
	//Consulta para listar todos os clientes em ordem alfabética
	@Query("SELECT DISTINCT c FROM Cliente c JOIN FETCH c.enderecos e ORDER BY c.nome ASC")
	List<Cliente> findAllClientesOrdenadosComEnderecos();
	
	//Consulta para buscar um cliente pelo Id juntamento o endereço
	@Query("SELECT c FROM Cliente c JOIN FETCH c.enderecos e WHERE c.id = :id")
	Optional<Cliente> findClienteComEnderecosById(@Param("id") UUID id);



}
