package dev.palhano.loja.dao.dto;

import java.time.LocalDate;

public class TotalVendasPorProdutoEUltimaVendaDTO {
	private String nomeProduto;
	private Long quantVendida;
	private LocalDate dataUltimaVenda;
	public TotalVendasPorProdutoEUltimaVendaDTO(String nomeProduto, Long quantVendida, LocalDate dataUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantVendida = quantVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}
	@Override
	public String toString() {
		return "TotalVendasPorProdutoEUltimaVendaRel [nomeProduto=" + nomeProduto + ", quantVendida=" + quantVendida
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}
}
