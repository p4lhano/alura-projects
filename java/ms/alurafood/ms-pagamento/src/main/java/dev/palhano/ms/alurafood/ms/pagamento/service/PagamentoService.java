package dev.palhano.ms.alurafood.ms.pagamento.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.palhano.ms.alurafood.ms.pagamento.dto.PagamentoDto;
import dev.palhano.ms.alurafood.ms.pagamento.entity.Pagamento;
import dev.palhano.ms.alurafood.ms.pagamento.entity.enuns.Status;
import dev.palhano.ms.alurafood.ms.pagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {
	@Autowired
	private PagamentoRepository repository;
	@Autowired
	private ModelMapper mapper;

	public Page<PagamentoDto> busqueTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(p -> mapper.map(p, PagamentoDto.class));
	}

	public PagamentoDto obterPorId(Long id) {
		Pagamento pagamento = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

		return mapper.map(pagamento, PagamentoDto.class);
	}

	public PagamentoDto criarPagamento(PagamentoDto dto) {
		Pagamento pagamento = mapper.map(dto, Pagamento.class);
		pagamento.setStatus(Status.CRIADO);
		repository.save(pagamento);

		return mapper.map(pagamento, PagamentoDto.class);
	}

	public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
		Pagamento pagamento = mapper.map(dto, Pagamento.class);
		pagamento.setId(id);
		pagamento = repository.save(pagamento);
		return mapper.map(pagamento, PagamentoDto.class);
	}

	public void excluirPagamento(Long id) {
		repository.deleteById(id);
	}
}
