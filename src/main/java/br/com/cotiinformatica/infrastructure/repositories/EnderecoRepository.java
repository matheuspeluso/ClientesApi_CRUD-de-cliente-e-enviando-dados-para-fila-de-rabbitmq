package br.com.cotiinformatica.infrastructure.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.domain.models.entities.Endereco;

public interface EnderecoRepository extends JpaRepository <Endereco, UUID>{
	
	@Query("SELECT e FROM Endereco e WHERE e.cliente.id = :idCliente")
    List<Endereco> buscarEnderecosPorCliente(@Param("idCliente") UUID idCliente);

}
