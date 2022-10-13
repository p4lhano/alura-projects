package dev.palhano.forum.alura.model.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import dev.palhano.forum.alura.model.Topico;
import dev.palhano.forum.alura.model.dto.TopicoDTO;
import dev.palhano.forum.alura.model.dto.TopicoDetalhesDTO;
import dev.palhano.forum.alura.model.dto.TopicoFormDTO;

@Component
public class TopicoMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public TopicoDTO toTopicoDTO(Topico topico) {
		return MODEL_MAPPER.map(topico, TopicoDTO.class);
	}
	
	public List<TopicoDTO> toTopicoDTO(List<Topico> topicoList) {
		return topicoList.stream()
				.map(this::toTopicoDTO)
//				.toList() // Disponivel apenas depois do java 11
				.collect(java.util.stream.Collectors.toList())
				;
	}

	public Page<TopicoDTO> toTopicoDTO(Page<Topico> topicos) {
		return topicos.map(this::toTopicoDTO);
	}
	
	public Topico toTopico(TopicoFormDTO topicoFormDTO) {
		Topico topico = MODEL_MAPPER.map(topicoFormDTO, Topico.class);
		topico.setId(null);
		return topico;
	}
	
	public TopicoDetalhesDTO toTopicoDetalhesDTO(Topico topico) {
		return MODEL_MAPPER.map(topico, TopicoDetalhesDTO.class);
	}

	
}
