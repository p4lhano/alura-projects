package dev.palhano.loja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedidos")
public class ItemPedidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double precoUnitario; 
	private Integer quant;
	@ManyToOne
	private PedidoEntity pedido;
	@ManyToOne
	private ProdutoEntity produto;
	
	public ItemPedidoEntity() {}
	public ItemPedidoEntity(PedidoEntity pedido, ProdutoEntity produto, Integer quant) {
		this.setPedido(pedido);
		this.setProduto(produto, quant);
	}
	
	public ItemPedidoEntity(ProdutoEntity produto, Integer quant) {
		this.setProduto(produto, quant);
	}
	
	public Long getId() {
		return id;
	}
	public Double getPrecoUnitario() {
		return precoUnitario;
	}
	public Integer getQuant() {
		return quant;
	}
	public PedidoEntity getPedido() {
		return pedido;
	}
	public ProdutoEntity getProduto() {
		return produto;
	}
	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}
	public void setProduto(ProdutoEntity produto,Integer quant) {
		this.precoUnitario = produto.getPreco();
		this.produto = produto;
		this.quant = quant;
	}
}
