package dev.palhano.forum.alura.model.dto;

public class TopicoFormDTO {
	private String titulo;
	private String mensagem;
//	private Usuario autor;
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
