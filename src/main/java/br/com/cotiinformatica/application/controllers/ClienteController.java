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

import br.com.cotiinformatica.domain.contracts.services.ClienteServices;
import br.com.cotiinformatica.domain.models.dtos.ClientePutRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired ClienteServices clienteServices;
	
	@PostMapping("/cadastrar")
	public ClienteResponseDto cadastrarCliente(@RequestBody @Valid ClienteRequestDto dto) {
		
		return clienteServices.cadastroCliente(dto);
	}
	
	@PutMapping("/alterar/{id}")
	public ClienteResponseDto alterarCliente(@PathVariable UUID id, @RequestBody @Valid ClientePutRequestDto dto) {
		
		return clienteServices.alterarCliente(dto, id);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ClienteResponseDto excluirCliente(@PathVariable UUID id) {

		return clienteServices.excluirCliente(id);
	}
	
	@GetMapping("/consultar")
	public List<ClienteResponseDto> consultarClientes() {

		return clienteServices.buscarTodosClientes();
	}
	
	@GetMapping("/consultar/{id}")
	public ClienteResponseDto consultarClientePorId(@PathVariable UUID id) {

		return clienteServices.buscarClientePorId(id);
	}
	
	
	
}
