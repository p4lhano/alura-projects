package dev.palhano.forum.alura.model.dto;

import java.util.Date;

import dev.palhano.forum.alura.config.security.TokenService;

public class TokenDTO {

	private String type = "Bearer";
	private String token;
	private Date expireAt;

	public TokenDTO(String token) {
		this.token = token;
	}
	
	/**
	 * @param tokenService caso passando dev.palhano.forum.alura.config.security.TokenService será extraido a data de expiração para retorno no objeto de resposta
	 * */
	public TokenDTO(String token,Date date) {
		this.token = token;
		this.expireAt = date;
	}

	public String getType() {
		return type;
	}

	public String getToken() {
		return token;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

}
