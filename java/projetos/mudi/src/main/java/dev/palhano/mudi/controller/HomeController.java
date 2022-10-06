package dev.palhano.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import dev.palhano.mudi.model.Pedido;
import dev.palhano.mudi.model.User;
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
	public String home(Model request,Principal principal) {
		
		User user = new User();
		user.setUsername(principal.getName());

//		List<Pedido> pedidos = pedidoRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
		
		List<Pedido> pedidos = pedidoRepository.findByOrderByIdDesc();
		
		Sort sort = Sort.by("dataEntrega").ascending();
		PageRequest paginacao = PageRequest.of(0, 2,sort);
		
//		pedidos = pedidoRepository.findByUser(user,sort); // Funciona, mas sem a paginação
		pedidos = pedidoRepository.findByUser(user, paginacao);
		System.out.println(principal.toString());
		
		request.addAttribute("pedidos", pedidos);
		
		
		return "home";
	}
	
	@GetMapping("{status}")
	public String find(@PathVariable String status, Model request) {
		
		User user = new User();
		user.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
		List<Pedido> pedidos = pedidoRepository.findByStatusAndUser(PedidoStatusEnum.valueOf(status.toUpperCase()),user);
		
		request.addAttribute("pedidos", pedidos);
		request.addAttribute("status", status);
		
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
