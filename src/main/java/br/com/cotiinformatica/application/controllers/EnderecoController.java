package br.com.cotiinformatica.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.contracts.services.EnderecoServices;
import br.com.cotiinformatica.domain.models.dtos.EnderecoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.EnderecoResponseDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente/enderecos")
public class EnderecoController {
	
	@Autowired EnderecoServices enderecoServices;
	
	@PostMapping("/cadastrar/{idCliente}")
	public EnderecoResponseDto cadastrarEndereco(@PathVariable UUID idCliente, @RequestBody @Valid EnderecoRequestDto dto) {
		
		return enderecoServices.cadastrarEndereco(dto, idCliente);
		
	}
	
	@PutMapping("/alterar/{id}")
	public EnderecoResponseDto alterarEndereco(@PathVariable UUID id, @RequestBody @Valid EnderecoRequestDto dto) {
		
		return enderecoServices.atualizarEndereco(dto, id);
	}
	
	@DeleteMapping("/excluir/{id}")
	public EnderecoResponseDto excluirEndereco(@PathVariable UUID id) {
		
		return enderecoServices.excluirEndereco(id);
	}
	
	@GetMapping("/consultar/{idCliente}")
	public List<EnderecoResponseDto> concultarEnderecosPorIdCliente(@PathVariable UUID idCliente){
		
		return enderecoServices.consultarEnderecosPorIdDoCliente(idCliente);
	}
	
}
