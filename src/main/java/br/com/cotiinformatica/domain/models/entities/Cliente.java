package br.com.cotiinformatica.domain.models.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;
	
	@Column(name = "dataNascimento", nullable = false)
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos;
		
}
