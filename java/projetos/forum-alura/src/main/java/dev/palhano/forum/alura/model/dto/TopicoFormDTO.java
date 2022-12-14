package dev.palhano.forum.alura.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TopicoFormDTO {
	@NotNull @NotEmpty @Length(min = 5,max = 255) //Bean Validation
	private String titulo;
	@NotNull @NotEmpty @Length(min = 10,max = 255)
	private String mensagem;
//	private Usuario autor;
	@NotNull @NotEmpty
	private String cursoId;
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
	public String getCursoId() {
		return cursoId;
	}
	public void setCursoId(String cursoId) {
		this.cursoId = cursoId;
	}
	@Override
	public String toString() {
		return "TopicoFormDTO [titulo=" + titulo + ", mensagem=" + mensagem + ", cursoId=" + cursoId + "]";
	}
}
