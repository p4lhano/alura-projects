package dev.palhano.forum.alura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.palhano.forum.alura.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}
