package dev.palhano.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.palhano.mudi.model.Pedido;
import dev.palhano.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	private final PedidoRepository pedidoRepository;
	public HomeController(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	@GetMapping("/home")
	public String home(Model request) {
		
		
		
		Iterable<Pedido> pedidos = pedidoRepository.findAll();
		request.addAttribute("pedidos", pedidos);
		
		
		return "home";
	}
}
