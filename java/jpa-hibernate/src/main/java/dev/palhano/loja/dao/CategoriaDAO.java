package dev.palhano.loja.dao;

import javax.persistence.EntityManager;

import dev.palhano.loja.models.CategoriaEntity;

public class CategoriaDAO {
	private EntityManager em;
	
	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(CategoriaEntity categoria){
		this.em.persist(categoria);
	}
	
	public void atualizar(CategoriaEntity categoria) {
		this.em.merge(categoria);
	}
	
	public void delete(CategoriaEntity categoria) {
		// ?? ainda em duvida
		categoria = this.em.merge(categoria);
		this.em.remove(categoria);
	}
	
	public CategoriaEntity findById(Long id) {
		return em.find(CategoriaEntity.class, id);
	}
	
}
