package br.com.cotiinformatica.domain.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "logradouro", length = 200, nullable = false)
	private String logradouro;
	
	@Column(name = "complemento", length = 150, nullable = false)
	private String complemento;
	
	@Column(name = "numero", length = 15, nullable = false)
	private String numero;
	
	@Column(name = "bairro", length = 150, nullable = false)
	private String bairro;
	
	@Column(name = "cidade", length = 150, nullable = false)
	private String cidade;
	
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;
	
	@Column(name = "cep", length = 8, nullable = false)
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
}
