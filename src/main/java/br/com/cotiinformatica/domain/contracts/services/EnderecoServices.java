package br.com.cotiinformatica.domain.contracts.services;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.models.dtos.EnderecoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.EnderecoResponseDto;

public interface EnderecoServices {
	
	EnderecoResponseDto cadastrarEndereco(EnderecoRequestDto request, UUID idCliente);
	
	EnderecoResponseDto atualizarEndereco(EnderecoRequestDto request, UUID id);
	
	EnderecoResponseDto excluirEndereco(UUID id);
	
	EnderecoResponseDto consultarEnderecoPorId(UUID id);
	
	List<EnderecoResponseDto> consultarEnderecosPorIdDoCliente(UUID idCliente);
	

}
