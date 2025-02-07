package br.com.cotiinformatica.domain.contracts.components;

public interface EmailMessage {
	public void criarEmail(String email, String nome, String assunto, String mensagem);
}
