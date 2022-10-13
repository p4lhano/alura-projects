package dev.palhano.forum.alura.model.dto;

import java.time.LocalDateTime;

public class RespostaDTO {
	private Long id;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String autorNome;
	
	public RespostaDTO() {}
	public RespostaDTO(Long id, String mensagem, LocalDateTime dataCriacao, String autorNome) {
		this.id = id;
		this.mensagem = mensagem;
		this.dataCriacao = dataCriacao;
		this.autorNome = autorNome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getAutorNome() {
		return autorNome;
	}
	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}
}
