package dev.palhano.ms.alurafood.ms.pagamento.dto;

import java.math.BigDecimal;

import dev.palhano.ms.alurafood.ms.pagamento.entity.enuns.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDto {
	private Long id;
	private BigDecimal valor;
	private String nome;
	private String numero;
	private String expiracao;
	private String codigo;
	private Status status;
	private Long pedidoId;
	private Long formaDePagamentoId;
}
