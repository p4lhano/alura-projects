package dev.palhano.forum.alura.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import dev.palhano.forum.alura.model.Topico;

public class TopicoUpdateFormDTO {
	@NotNull @NotEmpty @Length(min = 5,max = 255)
	private String titulo;
	@NotNull @NotEmpty @Length(min = 10,max = 255)
	private String mensagem;
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
	
	public void updateTopico(Topico topico) {
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
	}
	
}
