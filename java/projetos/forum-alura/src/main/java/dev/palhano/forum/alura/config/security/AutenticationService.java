package dev.palhano.forum.alura.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.palhano.forum.alura.model.Usuario;
import dev.palhano.forum.alura.repository.UsuarioRepository;

@Service
public class AutenticationService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario: "+ username + " não não corresponde a nenhum cadastro no banco de dados."));
		return usuario;
	}
	
}
