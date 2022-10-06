package dev.palhano.mudi.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.palhano.mudi.model.Pedido;
import dev.palhano.mudi.model.User;
import dev.palhano.mudi.model.types.PedidoStatusEnum;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	List<Pedido> findByOrderByIdDesc();

	List<Pedido> findByStatusAndUser(PedidoStatusEnum status,User username);

	/**
	 * Irá fazer a query apenas em na table {@code Pedido} comparando o nome da chave no campo
	 * 
	 * @param sort confure by org.springframework.data.domain.Sort
	 * @param paginacao 
	 * */
	List<Pedido> findByUser(User username, Pageable paginacao);
}
