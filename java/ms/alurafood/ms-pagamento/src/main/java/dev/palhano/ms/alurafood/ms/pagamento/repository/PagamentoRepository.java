package dev.palhano.ms.alurafood.ms.pagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.palhano.ms.alurafood.ms.pagamento.entity.Pagamento;
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
