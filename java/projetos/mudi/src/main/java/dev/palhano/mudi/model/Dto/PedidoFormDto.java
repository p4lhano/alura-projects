package dev.palhano.mudi.model.Dto;

import javax.validation.constraints.NotBlank;

import dev.palhano.mudi.model.Pedido;

public class PedidoFormDto {
		
	@NotBlank//https://docs.jboss.org/hibernate/beanvalidation/spec/2.0/api/javax/validation/constraints/package-summary.html
	private String nome;
	@NotBlank
	private String urlProduto;
	@NotBlank
	private String urlImage;
	private String descricao;
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNome(nome);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImage(urlImage);
		pedido.setDescricao(descricao);
		return pedido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	@Override
	public String toString() {
		return "PedidoFormDto [nome=" + nome + ", urlProduto=" + urlProduto + ", urlImage=" + urlImage + ", descricao="
				+ descricao + "]";
	}
}
