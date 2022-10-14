package dev.palhano.forum.alura.model.dto;

public class TokenDTO {

	private String type = "Bearer";
	private String token;

	public TokenDTO(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public String getToken() {
		return token;
	}

}
