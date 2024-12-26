package br.com.cotiinformatica.domain.models.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ClienteRequestDto {
	private String nome;
	private String email;
	
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	 
	 private EnderecoRequestDto endereco;

}
