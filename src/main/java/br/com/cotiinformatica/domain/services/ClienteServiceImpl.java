package br.com.cotiinformatica.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.contracts.services.ClienteServices;
import br.com.cotiinformatica.domain.models.dtos.ClientePutRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;
import br.com.cotiinformatica.domain.models.dtos.EnderecoResponseDto;
import br.com.cotiinformatica.domain.models.entities.Cliente;
import br.com.cotiinformatica.domain.models.entities.Endereco;
import br.com.cotiinformatica.infrastructure.repositories.ClienteRepository;
import br.com.cotiinformatica.infrastructure.repositories.EnderecoRepository;

@Service
public class ClienteServiceImpl implements ClienteServices{
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	@Autowired 
	EnderecoRepository enderecoRepository;

	@Override
	public ClienteResponseDto cadastroCliente(ClienteRequestDto request) {
		
		var endereco = enderecoConvert(request); // Convertendo o DTO de endereço em entidade Endereço
		
		var cliente = new Cliente();
		cliente.setId(UUID.randomUUID());
		cliente.setNome(request.getNome());
		cliente.setEmail(request.getEmail());
		cliente.setCpf(request.getCpf());
		cliente.setDataNascimento(request.getDataNascimento());
		
		//adicionando  o endereço ao cliente
		adicionarEnderecoAoCliente(cliente,endereco);

		//salvando o cliente (os endereços serão salvos juntamente com o cliente)
		cliente = clienteRepository.save(cliente);
		
		return toResponse(cliente);
		
	}

	@Override
	public ClienteResponseDto alterarCliente(ClientePutRequestDto request, UUID id) {
		var cliente = clienteRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Cliente não encontrado"));
		
		cliente.setNome(request.getNome());
		cliente.setEmail(request.getEmail());
		cliente.setCpf(request.getCpf());
		cliente.setDataNascimento(request.getDataNascimento());
		
		clienteRepository.save(cliente);
		
		return toResponse(cliente);
	}

	@Override
	public ClienteResponseDto excluirCliente(UUID id) {
		
		var cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
		
		clienteRepository.delete(cliente);
		return toResponse(cliente);
	}

	@Override
	public List<ClienteResponseDto> buscarTodosClientes() {
		
		var clientes = clienteRepository.findAll();
		
		if (clientes.isEmpty()) {
			throw new IllegalArgumentException("Nenhum cliente encontrado");
		}
		
		List<ClienteResponseDto> resposta = new ArrayList<>();
		
		for (Cliente cliente : clientes) {
			resposta.add(toResponse(cliente));
		}
		
		return resposta;
	}

	@Override
	public ClienteResponseDto buscarClientePorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private Endereco enderecoConvert(ClienteRequestDto dto) { // Método utilitário para converter um DTO de endereço em entidade Endereço
		var endereco = new Endereco();
		
		endereco.setId(UUID.randomUUID());
		endereco.setLogradouro(dto.getEndereco().getLogradouro());
	    endereco.setComplemento(dto.getEndereco().getComplemento());
	    endereco.setNumero(dto.getEndereco().getNumero());
	    endereco.setBairro(dto.getEndereco().getBairro());
	    endereco.setCidade(dto.getEndereco().getCidade());
	    endereco.setUf(dto.getEndereco().getUf());
	    endereco.setCep(dto.getEndereco().getCep());
		
		return endereco;
	}
	
	private ClienteResponseDto toResponse(Cliente cliente) {
		var response = new ClienteResponseDto();
		
		response.setId(cliente.getId());
		response.setNome(cliente.getNome());
		response.setCpf(cliente.getCpf());
		response.setEmail(cliente.getEmail());
		response.setDataNascimento(cliente.getDataNascimento().toString());
		var enderecos = cliente.getEnderecos().stream().map(this::toEnderecoResponse).toList();
	    response.setEnderecos(enderecos);
	    
	    return response;
	}

	private EnderecoResponseDto toEnderecoResponse(Endereco endereco) {
	    var response = new EnderecoResponseDto();
	    
	    response.setId(endereco.getId());
	    response.setLogradouro(endereco.getLogradouro());
	    response.setComplemento(endereco.getComplemento());
	    response.setNumero(endereco.getNumero());
	    response.setBairro(endereco.getBairro());
	    response.setCidade(endereco.getCidade());
	    response.setUf(endereco.getUf());
	    response.setCep(endereco.getCep());
	    
	    return response;
	}
	
	// Novo método utilitário para adicionar um endereço ao cliente
    private void adicionarEnderecoAoCliente(Cliente cliente, Endereco endereco) {
        endereco.setCliente(cliente); // Vincula o cliente ao endereço
        cliente.setEnderecos(List.of(endereco)); // Adiciona o endereço à lista de endereços do cliente
    }
	
}
