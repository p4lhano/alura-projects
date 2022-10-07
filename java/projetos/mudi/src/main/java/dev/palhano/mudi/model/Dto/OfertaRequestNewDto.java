package dev.palhano.mudi.model.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.palhano.mudi.model.Oferta;

public class OfertaRequestNewDto {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Long pedidoId;
	
	private String valor;
	
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
