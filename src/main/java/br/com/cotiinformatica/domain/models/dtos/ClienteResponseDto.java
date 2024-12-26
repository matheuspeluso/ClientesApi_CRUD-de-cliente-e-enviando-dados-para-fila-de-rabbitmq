package br.com.cotiinformatica.domain.models.dtos;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class ClienteResponseDto {

	private UUID id;
	private String nome;
	private String email;
	private String dataNascimento;
	private String cpf;
	private List <EnderecoResponseDto> enderecos;
}
