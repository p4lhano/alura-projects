package dev.palhano.mudi.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.palhano.mudi.model.Oferta;
import dev.palhano.mudi.model.Pedido;
import dev.palhano.mudi.model.Dto.OfertaRequestNewDto;
import dev.palhano.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaRestController {
	private final PedidoRepository pedidoRepository;
	
	public OfertaRestController(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	@PostMapping
	public Oferta createOferta(OfertaRequestNewDto ofertaRequestNew) {

		Oferta oferta = ofertaRequestNew.toOferta();
		
		Pedido pedido = pedidoRepository.findById(ofertaRequestNew.getPedidoId())
			.orElseThrow(() -> new IllegalArgumentException("Pedido id:" + ofertaRequestNew.getPedidoId() + " não encontrasse cadastrado!"));
		
		oferta.setPedido(pedido);
		pedido.getOfertas().add(oferta);
		pedidoRepository.save(pedido);
		/**
		 * Da para simplicar a consulta acima realiza indo ao banco uma unica vez, mas seria precisa criar o OfertaRepository, dando o salve apensa na ofetar, 
		 * o pedido.getOfertas() não será necessário
		 * 
		 * */
		
		
		
		
		return oferta;
	}
}
