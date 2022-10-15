package dev.palhano.forum.alura.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import dev.palhano.forum.alura.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.duration}")
	private String durationInMs;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	/**
	 * @param expireAtToken será setado com o valor que p token irá expirar
	 * */
	public String generateToken(Authentication authentication) {
		Usuario user = (Usuario) authentication.getPrincipal();
		Date now = new Date();
		Date expireAtToken = new Date(now.getTime() + Long.parseLong(durationInMs));
		
		return Jwts.builder()
				.setIssuer("API Forum")
				.setSubject(user.getId().toString())
				.setIssuedAt(now)
				.setExpiration(expireAtToken)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public Boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Long getIdUser(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		
		return Long.parseLong(claims.getSubject());
	}
	
	public Date getExpireAt(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return claims.getExpiration();
	}

}
