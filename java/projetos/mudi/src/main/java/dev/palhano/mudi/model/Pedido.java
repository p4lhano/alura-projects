package dev.palhano.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import dev.palhano.mudi.model.types.PedidoStatusEnum;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal valorNegociado;
	private LocalDate dataEntrega;
	private String urlProduto;
	private String urlImage;
	private String descricao;
	@Column(length = 30, nullable = false) @Enumerated(EnumType.STRING)
	private PedidoStatusEnum status = PedidoStatusEnum.AGUARDANDO;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "pedido")
	List<Oferta> ofertas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getDescricao() {
		return descricao;
	}
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public PedidoStatusEnum getStatus() {
		return status;
	}
	public void setStatus(PedidoStatusEnum status) {
		this.status = status;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
