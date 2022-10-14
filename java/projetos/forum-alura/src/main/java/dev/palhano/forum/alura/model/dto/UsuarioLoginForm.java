package dev.palhano.forum.alura.model.dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UsuarioLoginForm {
	@NotEmpty
	private String email;
	@NotEmpty
	private String senha;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "UsuarioLoginForm [email=" + email + ", senha=" + senha + "]";
	}
	public UsernamePasswordAuthenticationToken toDadaLogin() {
		return new UsernamePasswordAuthenticationToken(this.email, this.senha);
	}
}
