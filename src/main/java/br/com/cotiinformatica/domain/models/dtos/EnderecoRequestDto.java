package br.com.cotiinformatica.domain.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoRequestDto {
	
	@NotBlank(message =  "Por favor, informe o logradouro.")
	@Size(min = 8, max = 150 , message = "O logradouro deve ter de 8 a 150 caracteres.")
	private String logradouro;
	
	@NotBlank(message = "Por favor, informe o complemento.")
	@Size(min = 4, max = 150, message = "O complemento deve ter de 4 a 150 caracteres.")
	private String complemento;
	
	@NotBlank(message = "Por favor, o campo número não pode ficar em branco.")
	@Pattern(regexp = "^[A-Za-z0-9\\-\\s]+$", message = "O número da residência deve conter apenas letras, números, espaços ou traços.")
	@Size(min = 1, max = 10, message = "O número da residência deve ter de 1 a 10 caracteres.")
	private String numero;
	
	@NotBlank(message = "Por favor, informe o bairro do cliente.")
	@Size(min = 3, max = 100, message = "O bairro deve ter entre 3 e 100 caracteres.")
	private String bairro;

	
	@NotBlank(message = "Por favor, informe a UF.")
	@Pattern(regexp = "^[A-Z]{2}$", message = "A UF deve conter exatamente 2 letras maiúsculas.")
	private String uf;

	@NotBlank(message = "Por favor, informe o CEP do cliente.")
	@Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "O CEP deve estar no formato 12345-678 ou 12345678.")
	private String cep;


}
