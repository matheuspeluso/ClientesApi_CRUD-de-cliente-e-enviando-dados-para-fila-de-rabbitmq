package br.com.cotiinformatica.domain.contracts.services;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.models.dtos.ClientePutRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;

public interface ClienteServices {
	
	ClienteResponseDto cadastroCliente(ClienteRequestDto request);
	
	ClienteResponseDto alterarCliente(ClientePutRequestDto request, UUID id);
	
	ClienteResponseDto excluirCliente(UUID id);
	
	List <ClienteResponseDto> buscarTodosClientes();
	
	ClienteResponseDto buscarClientePorId(UUID id);

}
