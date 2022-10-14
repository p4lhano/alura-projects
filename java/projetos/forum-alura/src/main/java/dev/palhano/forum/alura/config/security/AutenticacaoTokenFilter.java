package dev.palhano.forum.alura.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import dev.palhano.forum.alura.config.validation.NotFoundException;
import dev.palhano.forum.alura.model.Usuario;
import dev.palhano.forum.alura.repository.UsuarioRepository;


/**
 * Depois do token gerado, essa classe ira interceptar a requisição para cumprir o STATELLES
 * */
public class AutenticacaoTokenFilter extends OncePerRequestFilter {
	
	private final TokenService tokenService;
	private final UsuarioRepository usuarioRepository;
	
	public AutenticacaoTokenFilter(TokenService tokenService,UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		String token = findToken(request);
		
		Boolean valid = tokenService.isValid(token);
		
		if (valid)
			authenticate(token);
			
		filterChain.doFilter(request, response);
	}


	private String findToken(HttpServletRequest request) {
		String t = request.getHeader("Authorization");
		
		if (t == null || t.isEmpty() || !t.startsWith("Bearer "))
			return null;
		
		return t.substring(7,t.length());
	}

	private void authenticate(String token) {
		Long idUser = tokenService.getIdUser(token);
		Usuario usuario = usuarioRepository.findById(idUser)
				.orElseThrow(() -> new NotFoundException());
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
}
