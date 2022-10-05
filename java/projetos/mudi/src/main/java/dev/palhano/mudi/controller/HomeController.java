package dev.palhano.mudi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.palhano.mudi.model.Pedido;
import dev.palhano.mudi.model.types.PedidoStatusEnum;
import dev.palhano.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	private final PedidoRepository pedidoRepository;
	public HomeController(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	@GetMapping
	public String home(Model request) {
		
		
		
//		List<Pedido> pedidos = pedidoRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
		List<Pedido> pedidos = pedidoRepository.findByOrderByIdDesc();
		
		
		request.addAttribute("pedidos", pedidos);
		
		
		return "home";
	}
	
	@GetMapping("{status}")
	public String find(@PathVariable String status, Model request) {
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(PedidoStatusEnum.valueOf(status.toUpperCase()));
		
		request.addAttribute("pedidos", pedidos);
		request.addAttribute("status", status);
		
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
