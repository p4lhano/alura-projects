package dev.palhano.forum.alura.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.palhano.forum.alura.config.security.TokenService;
import dev.palhano.forum.alura.model.dto.TokenDTO;
import dev.palhano.forum.alura.model.dto.UsuarioLoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired //Por padrão essa classe não é possivel fazer a injeção de dependencia, Spring não esta configurado para isso, assim na SecurityConfiguration foi dado Override no authenticationManager() da classe WebSecurityConfigurerAdapter 
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> auth(@RequestBody @Valid UsuarioLoginForm user) {
		System.out.println(user);
		
		UsernamePasswordAuthenticationToken dadaLogin = user.toDadaLogin();
		
		try {
			Authentication authentication = authenticationManager.authenticate(dadaLogin);
			String token = tokenService.generateToken(authentication);
			
			TokenDTO tokenDTO=new TokenDTO(token);
			
			return ResponseEntity.ok(tokenDTO);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest()
//					.body(e.getMessage())
					.build(); 
		}
	}
}
