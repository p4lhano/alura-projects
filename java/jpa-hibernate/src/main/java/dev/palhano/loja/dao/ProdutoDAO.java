package dev.palhano.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import dev.palhano.loja.models.ProdutoEntity;

public class ProdutoDAO {
	private EntityManager em;
	
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(ProdutoEntity produto){
		this.em.persist(produto);
	}
	
	public ProdutoEntity findById(Long id) {
		return em.find(ProdutoEntity.class, id);
	}
	
	public List<ProdutoEntity> findAll() {
//		jpql sempre faz referencia a classe não a tabela
		String jpsql = "select p from ProdutoEntity p";
		return em.createQuery(jpsql,ProdutoEntity.class).getResultList();
	}
	
	public List<ProdutoEntity> findByName(String nome) {
		String jpsql = "select p from ProdutoEntity p where p.nome = :nome";
		return em.createQuery(jpsql,ProdutoEntity.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
}
