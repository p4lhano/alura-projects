package dev.palhano.mudi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.palhano.mudi.model.Pedido;
import dev.palhano.mudi.model.types.PedidoStatusEnum;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	List<Pedido> findByOrderByIdDesc();

	List<Pedido> findByStatus(PedidoStatusEnum status);
}
