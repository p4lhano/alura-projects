package dev.palhano.forum.alura.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import dev.palhano.forum.alura.model.Resposta;
import dev.palhano.forum.alura.model.dto.RespostaDTO;

@Component
public class RespostaMapper {
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public RespostaDTO toRespostaDTO(Resposta resposta) {
		return MODEL_MAPPER.map(resposta, RespostaDTO.class);
	}
	
	public List<RespostaDTO> toRespostaDTO(List<Resposta> respostaList) {
		return respostaList.stream()
				.map(this::toRespostaDTO)
				.collect(Collectors.toList());
	}
	
}
