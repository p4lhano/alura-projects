package dev.palhano.mudi.model.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import dev.palhano.mudi.model.Oferta;

public class OfertaRequestNewDto {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@NotNull
	private Long pedidoId;
	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	private String valor;
	@NotNull
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
	private String dataEntrega;
	
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public Oferta toOferta() {
		Oferta o = new Oferta();
		o.setComentario(comentario);
		o.setDataEntrega(LocalDate.parse(dataEntrega, FORMATTER));
		o.setValor(new BigDecimal(valor));
		return o;
	}
}
