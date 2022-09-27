package dev.palhano.loja.acoes;

import javax.persistence.EntityManager;

import dev.palhano.loja.dao.CategoriaDAO;
import dev.palhano.loja.dao.ProdutoDAO;
import dev.palhano.loja.models.CategoriaEntity;
import dev.palhano.loja.models.ProdutoEntity;
import dev.palhano.loja.util.JPAUtil;

public class CadastroProdutoAcao {
	public static void main(String[] args) {
		testeCadastro();
		testeBusca();
	}

	private static void testeBusca() {
		EntityManager em = JPAUtil.getEntityManagerFactory();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		
		ProdutoEntity produto = produtoDao.findById(1L);
		
		produtoDao.findAll().stream().forEach(System.out::println);;
		
		
	}

	private static void testeCadastro() {
		CategoriaEntity cateria = new CategoriaEntity("CELULAR");
		ProdutoEntity produto = new ProdutoEntity();
		
		produto.setNome("mesa");
		produto.setDescricao("Mesa de canto");
		produto.setPreco(230.0);
		produto.setCategoria(cateria);
		
		EntityManager em = JPAUtil.getEntityManagerFactory() ;
		/**
		 * Em frameworks é feito via injeção de dependencias, '@autoried' or private atribute static in construct
		 * */
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		/**
		 * Em frameworks é feito via injeção de dependencias, '@autoried' or private atribute static in construct
		 * */
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		System.out.println("Inicia transação");
		em.getTransaction().begin();
		categoriaDAO.cadastrar(cateria);
		System.out.println("Cadastrou categia id: " + cateria.getId());
		produtoDao.cadastrar(produto);
		em.getTransaction().commit();
		System.out.println("Comitou");
		em.close();
	}
}
