package dev.palhano.loja.acoes;

import java.util.List;

import javax.persistence.EntityManager;

import dev.palhano.loja.dao.dto.TotalVendasPorProdutoEUltimaVendaDTO;

public class Relatorios {
	
private EntityManager em;
	
	public Relatorios(EntityManager em) {
		this.em = em;
	}
	
	public List<TotalVendasPorProdutoEUltimaVendaDTO> totalVendasPorProdutoEUltimaVenda() {
		String jpsql =
				"select new dev.palhano.loja.dao.dto.TotalVendasPorProdutoEUltimaVendaDTO("
							+ "produto.nome, "
							+ "sum(item.quant), "
							+ "max(pedido.data)) "
						+ "from PedidoEntity pedido "
				+ "join pedido.itens item "
				+ "join item.produto produto "
				+ "group by produto.nome "
				+ "order by produto.nome";
		return em.createQuery(jpsql,TotalVendasPorProdutoEUltimaVendaDTO.class)
				.getResultList();
	}
}
