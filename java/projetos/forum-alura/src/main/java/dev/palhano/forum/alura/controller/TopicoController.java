package dev.palhano.forum.alura.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.palhano.forum.alura.model.Curso;
import dev.palhano.forum.alura.model.Topico;
import dev.palhano.forum.alura.model.dto.TopicoDTO;
import dev.palhano.forum.alura.model.dto.TopicoFormDTO;
import dev.palhano.forum.alura.model.mapper.TopicoMapper;
import dev.palhano.forum.alura.repository.TopicoRepository;

@RestController
@RequestMapping("${apiPrefix}/topicos")
public class TopicoController {
	
	@Value("${apiPrefix}/topicos")
	private String apiPrefixTopicos;
	
	private final TopicoMapper topicoMapper;
	private final TopicoRepository topicoRepository;
	
	public TopicoController(TopicoMapper topicoMapper,TopicoRepository topicoRepository) {
		this.topicoMapper = topicoMapper;
		this.topicoRepository = topicoRepository;
	}
	
	@GetMapping
	public List<TopicoDTO> getListTopicos() {
		Topico t1 = new Topico("Ajusta com algo", "mensagem", new Curso("Java", "Programação"));
		Topico t2 = new Topico("Ajusta com algo", "mensagem", new Curso("Java", "Programação"));
		
		List<Topico> list = new ArrayList<>();
		list.add(t1);
		list.add(t2);
		
		List<Topico> list2 = topicoRepository.findAll();
		System.out.println("Listou todos");
		return topicoMapper.toTopicoDTO(list2);
	}
	
	/**
	 * @exception org.postgresql.util.PSQLException em casos de não existir o Id do curso no banco
	 * */
	@PostMapping
	public ResponseEntity<TopicoDTO> createNew(@RequestBody TopicoFormDTO topicoForm,UriComponentsBuilder uriBuilder) {
		
		Topico topico = topicoMapper.toTopico(topicoForm);
		
		topicoRepository.save(topico);
		URI uri = uriBuilder.path(apiPrefixTopicos+"/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(topicoMapper.toTopicoDTO(topico));
	}
}
