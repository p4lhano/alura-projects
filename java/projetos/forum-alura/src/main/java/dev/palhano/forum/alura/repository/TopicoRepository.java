package dev.palhano.forum.alura.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.palhano.forum.alura.model.Topico;

@Repository
public interface TopicoRepository extends CrudRepository<Topico, Long> {
	
	List<Topico> findAll();
	
	Page<Topico> findByCurso_Nome(String nome, Pageable pageable);

	Page<Topico> findAll(Pageable pageable);
	
}
