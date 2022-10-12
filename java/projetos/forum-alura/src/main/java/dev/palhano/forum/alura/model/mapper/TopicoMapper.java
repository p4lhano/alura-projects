package dev.palhano.forum.alura.model.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dev.palhano.forum.alura.model.Topico;
import dev.palhano.forum.alura.model.dto.TopicoDTO;

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
}
