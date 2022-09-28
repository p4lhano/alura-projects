package dev.palhano.loja.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data_pedido")
	private LocalDate data;
	private Double valor;
	
	@ManyToOne(fetch = FetchType.LAZY)	// join fecth para carregar junto então na jpql
	private ClienteEntity cliente;

//	@OneToMany(mappedBy = "pedido")// diz que já existe o relacionamento criado na outra ponta, e indica qual é a variavel utilizada que foi mapeada já
	@OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)// diz que já existe o relacionamento criado na outra ponta, e indica qual é a variavel utilizada que foi mapeada já
	private List<ItemPedidoEntity> itens = new ArrayList<>();
	
	
	public PedidoEntity() {}
	public PedidoEntity(LocalDate data, ClienteEntity cliente) {
		this.data = data;
		this.cliente = cliente;
	}
	
	public Long getId() { return id; }
	public LocalDate getData() { return data; }
	public Double getValor() { return valor; }
	
	public void addItem(ItemPedidoEntity item) {
//		item.setPedido(this);
		this.itens.add(item);
	}
}
