package dev.palhano.loja.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoEntity {/*
	 * Poderia ficar assim, por padrão a implementação do hibernate cria e busca a
	 * tabela com nome da classe, mas foge as convenções de banco de dados e que poderia esperar do java
	 * 
	 * @Entity
	 * public class Produto {
	 * }
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	public ProdutoEntity() {}
	public ProdutoEntity(String nome, String descricao, Double preco, CategoriaEntity categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	@Column(name = "valor")
	private Double preco;
	@ManyToOne()
	private CategoriaEntity categoria;
	
	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}
	
	public CategoriaEntity getCategoria() {
		return categoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", categoria=" + categoria.getNome() + "]";
	}
	
	
	
	
}
