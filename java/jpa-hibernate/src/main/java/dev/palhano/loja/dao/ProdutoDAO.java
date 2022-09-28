package dev.palhano.loja.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	//opcionais -jeito antigo
	public List<ProdutoEntity> findParametrosNulos(String nome,String descricao) {
		String jpsql = "select p from ProdutoEntity p where 1=1 ";
		if (nome != null && !nome.trim().isEmpty()) {
			jpsql += " and p.nome = :nome ";
		}
		if (descricao != null && !descricao.trim().isEmpty()) {
			jpsql += " and p.descricao = :descricao ";
		}
		
		TypedQuery<ProdutoEntity> query = em.createQuery(jpsql,ProdutoEntity.class);
		
		if (nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if (descricao != null && !descricao.trim().isEmpty()) {
			query.setParameter("descricao", descricao);
		}
		
		return query.getResultList();
	}
	
	public List<ProdutoEntity> findParametrosNulosCriteria(String nome,String descricao) {
		
		CriteriaBuilder builder = em .getCriteriaBuilder();
		
		CriteriaQuery<ProdutoEntity> query = builder.createQuery(ProdutoEntity.class);
		
		Root<ProdutoEntity> from = query.from(ProdutoEntity.class);
		
		Predicate andFiltro = builder.and();
		
		if (nome != null && !nome.trim().isEmpty()) {
			andFiltro = builder.and(andFiltro,builder.equal(from.get("nome"), nome));
		}
		if (descricao != null && !descricao.trim().isEmpty()) {
			andFiltro = builder.and(andFiltro,builder.equal(from.get("descricao"), descricao));
		}
		
		query.where(andFiltro);
		
		return em.createQuery(query).getResultList();
	}
}
