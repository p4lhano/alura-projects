package dev.palhano.forum.alura.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.palhano.forum.alura.config.validation.NotFoundException;
import dev.palhano.forum.alura.model.Topico;
import dev.palhano.forum.alura.model.dto.TopicoDTO;
import dev.palhano.forum.alura.model.dto.TopicoDetalhesDTO;
import dev.palhano.forum.alura.model.dto.TopicoFormDTO;
import dev.palhano.forum.alura.model.dto.TopicoUpdateFormDTO;
import dev.palhano.forum.alura.model.mapper.RespostaMapper;
import dev.palhano.forum.alura.model.mapper.TopicoMapper;
import dev.palhano.forum.alura.repository.TopicoRepository;

@RestController
@RequestMapping("${apiPrefix}/topicos")
public class TopicoController {
	
	@Value("${apiPrefix}/topicos")
	private String apiPrefixTopicos;
	
	private final TopicoMapper topicoMapper;
	private final RespostaMapper respostaMapper;
	private final TopicoRepository topicoRepository;
	
	public TopicoController(TopicoMapper topicoMapper,TopicoRepository topicoRepository,RespostaMapper respostaMapper) {
		this.topicoMapper = topicoMapper;
		this.topicoRepository = topicoRepository;
		this.respostaMapper = respostaMapper;
	}

	@GetMapping
	public List<TopicoDTO> getListTopicos() {
		
		List<Topico> list2 = topicoRepository.findAll();
		System.out.println("Listou todos");
		return topicoMapper.toTopicoDTO(list2);
	}
	@GetMapping("by")
	public ResponseEntity<Page<TopicoDTO>> findByCoursesNames(@RequestParam(required = false) String nomeCurso,@RequestParam int pag,@RequestParam int quant,@RequestParam(required = false) String order ) {

		
		Pageable pageable = PageRequest.of(pag, quant,Sort.by(order).descending());
		
		Page<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso,pageable);
//		topicoMapper.toTopicoDTO(topicos);
		return ResponseEntity.ok(topicoMapper.toTopicoDTO(topicos));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TopicoDetalhesDTO> getTopico(@PathVariable Long id) {
		Topico topico = topicoRepository.findById(id)
//				.orElseThrow(() -> new IllegalArgumentException("Id "+ id + " não existe cadastrado."));
				.orElseThrow(() -> new NotFoundException("Id "+ id + " não existe cadastrado."));
		
		TopicoDetalhesDTO topicoDetalhesDTO = topicoMapper.toTopicoDetalhesDTO(topico);
		topicoDetalhesDTO.setRespostas(respostaMapper.toRespostaDTO(topico.getRespostas()));
		
		
		return ResponseEntity.ok(topicoDetalhesDTO)  ;
	}
	
	/**
	 * @exception org.postgresql.util.PSQLException em casos de não existir o Id do curso no banco
	 * */
	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDTO> createNew(@Valid @RequestBody TopicoFormDTO topicoForm,UriComponentsBuilder uriBuilder) {
		
		Topico topico = topicoMapper.toTopico(topicoForm);
		
		topicoRepository.save(topico);
		URI uri = uriBuilder.path(apiPrefixTopicos+"/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(topicoMapper.toTopicoDTO(topico));
	}
	
	/**
	 * @exception IllegalArgumentException caso o id não exista para atualização
	 * 
	 *  @apiNote teste depois com o update diretamente o repositpry, passando os paramentros
	 * */
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<TopicoDTO> updateTopico(@PathVariable Long id,@Valid @RequestBody TopicoUpdateFormDTO topicoUpdate) {
		Topico topico = topicoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id "+ id + " não existe cadastrado."));
		topicoUpdate.updateTopico(topico);
//		topicoRepository.save(topico);
		return ResponseEntity.ok(topicoMapper.toTopicoDTO(topico));
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> deleteTopico(@PathVariable Long id) {
		try {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("Id "+ id + " não existe cadastrado.");
		}
	}
	
	
	
}
