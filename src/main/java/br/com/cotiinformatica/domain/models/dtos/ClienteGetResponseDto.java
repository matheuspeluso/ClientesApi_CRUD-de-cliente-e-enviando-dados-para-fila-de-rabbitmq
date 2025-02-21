package br.com.cotiinformatica.domain.models.dtos;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ClienteGetResponseDto {

    private UUID id;
    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
    private List<EnderecoResponseDto> enderecos;
    
}
