package br.com.cotiinformatica.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.contracts.services.EnderecoServices;
import br.com.cotiinformatica.domain.models.dtos.EnderecoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.EnderecoResponseDto;
import br.com.cotiinformatica.domain.models.entities.Endereco;
import br.com.cotiinformatica.infrastructure.repositories.ClienteRepository;
import br.com.cotiinformatica.infrastructure.repositories.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoServices{
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public EnderecoResponseDto cadastrarEndereco(EnderecoRequestDto request, UUID idCliente) {
		
		//buscando o cliente na qual associaremos com o endereço
		var cliente = clienteRepository.findById(idCliente)
				.orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
		
		var endereco = new Endereco();
		endereco.setId(UUID.randomUUID());
		endereco.setLogradouro(request.getLogradouro());
		endereco.setNumero(request.getNumero());
		endereco.setComplemento(request.getComplemento());
		endereco.setBairro(request.getBairro());
		endereco.setCidade(request.getCidade());
		endereco.setUf(request.getUf());
		endereco.setCep(request.getCep());
		
		//associando o endereço a um cliente 
		endereco.setCliente(cliente);
		
		//salvando o endereço no banco de dados
		endereco = enderecoRepository.save(endereco);
		return toEnderecoResponse(endereco);
	}

	@Override
	public EnderecoResponseDto atualizarEndereco(EnderecoRequestDto request, UUID id) {
		
		var endereco = enderecoRepository.findById(id)
		        .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));
		
		endereco.setLogradouro(request.getLogradouro());
	    endereco.setNumero(request.getNumero());
	    endereco.setComplemento(request.getComplemento());
	    endereco.setBairro(request.getBairro());
	    endereco.setCidade(request.getCidade());
	    endereco.setUf(request.getUf());
	    endereco.setCep(request.getCep());

	    endereco = enderecoRepository.save(endereco);
	    return toEnderecoResponse(endereco);
	}

	@Override
	public EnderecoResponseDto excluirEndereco(UUID id) {
		
		 var endereco = enderecoRepository.findById(id)
			        .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));

			    enderecoRepository.delete(endereco);
			    return toEnderecoResponse(endereco);
	}

	
	@Override
	public List<EnderecoResponseDto> consultarEnderecosPorIdDoCliente(UUID idCliente) {
		
		var enderecos = enderecoRepository.buscarEnderecosPorCliente(idCliente);
		
		if(enderecos.isEmpty()) {
			throw new IllegalArgumentException("Nennhum endereço encontrado para este cliente!");
		}
				
		return enderecos.stream().map(this::toEnderecoResponse).toList();
	}
	
	
	private EnderecoResponseDto toEnderecoResponse(Endereco endereco) {
	    return new EnderecoResponseDto(
	        endereco.getId(),
	        endereco.getLogradouro(),
	        endereco.getNumero(),
	        endereco.getComplemento(),
	        endereco.getBairro(),
	        endereco.getCidade(),
	        endereco.getUf(),
	        endereco.getCep()
	    );
	}


}
