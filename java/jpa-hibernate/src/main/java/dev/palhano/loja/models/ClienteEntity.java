package dev.palhano.loja.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded // casse embarcadas vai criar na mesma tabela
	private DadosPessoais dadosPessoais;
	
	public ClienteEntity() {}
	public ClienteEntity(String nome, String cpf) {
		this.dadosPessoais = new DadosPessoais();
		this.dadosPessoais.setNome(nome);
		this.dadosPessoais.setCpf(cpf);;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return dadosPessoais.getNome();
	}
	public String getCpf() {
		return dadosPessoais.getCpf();
	}
}
