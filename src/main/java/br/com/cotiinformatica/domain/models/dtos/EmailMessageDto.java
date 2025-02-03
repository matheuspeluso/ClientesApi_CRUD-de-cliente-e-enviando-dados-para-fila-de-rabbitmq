package br.com.cotiinformatica.domain.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class EmailMessageDto {
	
	private UUID id;
	private ClienteResponseDto cliente;
	private String assunto;
	private String mensagem;

}
