package br.com.cotiinformatica.domain.contracts.components;

import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;

public interface EmailMessage {
	public void criarEmail(ClienteResponseDto cliente, String assunto, String mensagem);
}
