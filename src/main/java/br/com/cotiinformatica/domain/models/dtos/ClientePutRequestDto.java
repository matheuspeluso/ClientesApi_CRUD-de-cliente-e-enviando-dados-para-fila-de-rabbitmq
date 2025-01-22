package br.com.cotiinformatica.domain.models.dtos;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientePutRequestDto {
	
	@NotBlank(message = "Por favor, informe o nome do cliente")
	@Size(min = 8, max = 150, message = "O nome do cliente deve ter de 8 a 150 caracteres.")
	private String nome;
	
	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotEmpty(message = "Por favor, informe o email do cliente.")
	private String email;
	
	@Pattern(
		    regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$", 
		    message = "Por favor, informe um CPF válido. Exemplo: 123.456.789-00 ou 12345678900."
		)
	@NotEmpty(message = "Por favor, informe o cpf do cliente.")
	private String cpf;
	
	 @NotNull(message = "Por favor, informe a data de nascimento do cliente.")
	 @Past(message = "A data de nascimento deve estar no passado.")
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	 

}
