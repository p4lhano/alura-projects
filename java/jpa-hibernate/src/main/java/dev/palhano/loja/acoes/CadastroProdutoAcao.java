package dev.palhano.loja.acoes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import dev.palhano.loja.dao.CategoriaDAO;
import dev.palhano.loja.dao.ProdutoDAO;
import dev.palhano.loja.dao.dto.TotalVendasPorProdutoEUltimaVendaDTO;
import dev.palhano.loja.models.CategoriaEntity;
import dev.palhano.loja.models.ClienteEntity;
import dev.palhano.loja.models.ItemPedidoEntity;
import dev.palhano.loja.models.PedidoEntity;
import dev.palhano.loja.models.ProdutoEntity;
import dev.palhano.loja.util.JPAUtil;

public class CadastroProdutoAcao {
	public static void main(String[] args) {
		testeCadastroProduto();
		testeCadastroPedido();
//		testeBusca();
		testeBuscaManyToMany();
		
		List<TotalVendasPorProdutoEUltimaVendaDTO> rel = new Relatorios(JPAUtil.getEntityManagerFactory()).totalVendasPorProdutoEUltimaVenda();
		rel.stream().forEach(System.out::println);
	}
	
	private static void testeBuscaManyToMany() {
		EntityManager em = JPAUtil.getEntityManagerFactory();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		
	}

	private static void testeBusca() {
		EntityManager em = JPAUtil.getEntityManagerFactory();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		
		ProdutoEntity produto = produtoDao.findById(1L);
		
		produtoDao.findAll().stream().forEach(System.out::println);;
		
		
	}

	private static void testeCadastroPedido() {
		EntityManager em = JPAUtil.getEntityManagerFactory();
		ClienteEntity cliente = new ClienteEntity("Vitor","123");
		ProdutoEntity produto = new ProdutoDAO(em).findById(1L);
		PedidoEntity pedido = new PedidoEntity(LocalDate.now(), cliente);
		
		pedido.addItem(new ItemPedidoEntity(pedido,produto,2));
		pedido.addItem(new ItemPedidoEntity(pedido,produto,3));
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.persist(pedido);
		em.getTransaction().commit();
	}
	
	private static void testeCadastroProduto() {
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
		em.getTransaction().begin();
		categoriaDAO.cadastrar(cateria);
		produtoDao.cadastrar(produto);
		em.getTransaction().commit();
		em.close();
	}
}
