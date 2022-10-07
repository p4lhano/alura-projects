package dev.palhano.mudi.api.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.palhano.mudi.model.Pedido;
import dev.palhano.mudi.model.types.PedidoStatusEnum;
import dev.palhano.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedido")
public class PedidoRestController {
	private final PedidoRepository pedidoRepository;
	
	public PedidoRestController(PedidoRepository pedidoRepository){
		this.pedidoRepository = pedidoRepository;
	}
	
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas() {
		System.out.println("Chamou getPedidosAguardandoOfertas");
		Sort sort = Sort.by("id").ascending();
		PageRequest paginacao = PageRequest.of(0, 2,sort);
		
		return pedidoRepository.findByStatus(PedidoStatusEnum.AGUARDANDO,paginacao);
	}
}
