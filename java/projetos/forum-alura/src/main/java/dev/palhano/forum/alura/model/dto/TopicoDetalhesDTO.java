package dev.palhano.forum.alura.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import dev.palhano.forum.alura.model.StatusTopico;

public class TopicoDetalhesDTO {
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private StatusTopico status;
	private String autorNome;
	private List<RespostaDTO> respostas;
	
	
	public TopicoDetalhesDTO() {}
	public TopicoDetalhesDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, String autorNome, List<RespostaDTO> respostas) {
		this.id = id;
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.dataCriacao = dataCriacao;
		this.status = status;
		this.autorNome = autorNome;
		this.respostas = respostas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public StatusTopico getStatus() {
		return status;
	}
	public void setStatus(StatusTopico status) {
		this.status = status;
	}
	public String getAutorNome() {
		return autorNome;
	}
	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}
	public List<RespostaDTO> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<RespostaDTO> respostas) {
		this.respostas = respostas;
	}
}
